package com.sist.dao;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data="서울특별시 강남구 선릉로161길 7 1F 지번 서울시 강남구 신사동 664-24 1F";
		data=data.substring(data.lastIndexOf("구")+1,data.lastIndexOf("동")+1);
		System.out.println(data.trim());
        /*EmpDAO dao=new EmpDAO();
        ArrayList<EmpVO> list=dao.empAllData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEname()+" "
        			+vo.getDvo().getDname());
        }*/
	}

}
