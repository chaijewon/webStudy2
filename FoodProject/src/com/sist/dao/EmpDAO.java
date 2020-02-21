package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
public class EmpDAO {
   private Connection conn;
   private PreparedStatement ps;
   private static EmpDAO dao;
   // 미리 생성된 Connection 객체를 얻어온다 
   /*
    *     Connection[] conn={100,200,300,400,500}
    *     boolean[] sw={false,false,false,false,false}
    *     if(요청.equals("jdbc/oracle"))
    *     {
    *        for(int i=0;i<5;i++)
    *        {
    *           if(sw[i]==false)
    *           {
    *              return conn[i];
    *              break;
    *           }
    *        }
    *     }
    */
   public void getConnection()
   {
	   try
	   {
		   Context init=new InitialContext(); // JNDI(Java Naming Directory Interface)
		   //턈색기를 연다 
		   Context c=(Context)init.lookup("java://comp//env");
		   // lookup => setLookup("별칭",클래스주소)
		   //저장된 폴더위치로 접근 
		   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
		   //실제 Connection주소 요청 ==> 오라클 정보외 관련된 모든 정보를 전송 (DataSource)
		   conn=ds.getConnection();
		   // 주소값을 넘겨받는다 
	   }catch(Exception ex){}
   }
   // 반환
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex){}
   }
   // 기능 
   public ArrayList<EmpVO> empAllData()
   {
	   ArrayList<EmpVO> list=new ArrayList<EmpVO>();
	   try
	   {
		   getConnection();// 사용할 주소를 얻어 온다 
		   String sql="SELECT empno,ename,job,hiredate,sal,dname,loc "
				     +"FROM emp,dept "
				     +"WHERE emp.deptno=dept.deptno";
		   //String sql="SELECT * FROM emp_dept";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   EmpVO vo=new EmpVO();
			   vo.setEmpno(rs.getInt(1));
			   vo.setEname(rs.getString(2));
			   vo.setJob(rs.getString(3));
			   vo.setHiredate(rs.getDate(4));
			   vo.setSal(rs.getInt(5));
			   vo.getDvo().setDname(rs.getString(6));
			   vo.getDvo().setLoc(rs.getString(7));
			   
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
		   // 반환 
	   }
	   return list;
   }
}







