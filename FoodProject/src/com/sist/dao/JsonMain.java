package com.sist.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonMain {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        String json="{\"datas\":[{\"rank\":1,\"title\":\"1987\"},{\"rank\":2,\"title\":\"신과함께-죄와 벌\"},{\"rank\":3,\"title\":\"쥬만지: 새로운 세계\"},{\"rank\":4,\"title\":\"코코\"},{\"rank\":5,\"title\":\"강철비\"},{\"rank\":6,\"title\":\"위대한 쇼맨\"},{\"rank\":7,\"title\":\"다운사이징\"},{\"rank\":8,\"title\":\"페르디난드\"},{\"rank\":9,\"title\":\"원더\"},{\"rank\":10,\"title\":\"쏘아올린 불꽃, 밑에서 볼까? 옆에서 볼까?\"}]}";
        JSONParser jp=new JSONParser();
        JSONObject movie=(JSONObject)jp.parse(json);
        System.out.println(movie.toJSONString());
        JSONArray arr=(JSONArray)movie.get("datas");
        System.out.println(arr.toJSONString());
        for(int i=0;i<arr.size();i++)
        {
        	JSONObject obj=(JSONObject)arr.get(i);
        	long rank=(long)obj.get("rank");
        	String title=(String)obj.get("title");
        	System.out.println(rank+"."+title);
        }
        
	}

}
