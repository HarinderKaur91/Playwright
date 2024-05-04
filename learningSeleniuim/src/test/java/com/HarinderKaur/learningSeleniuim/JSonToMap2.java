package com.HarinderKaur.learningSeleniuim;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

public class JSonToMap2 {

	public static void main(String[] args) {
	        // Sample JSON data
//	        String jsonStr1 = "{\"id\": 1, \"name\": \"John\"}";
//	        String jsonStr2 = "{\"id\": 2, \"name\": \"Alice\"}";
//	        String jsonStr3 = "{\"id\": 3, \"name\": \"Bob\"}";
	        
	        JSONObject obj = new JSONObject();
	        obj.put("Key1","value1");
	        obj.put("Key2","value2");

	        Map<String, String> map = new Gson().fromJson(obj.toString(),HashMap.class);
	        
	        for(Map.Entry<String, String> itr: map.entrySet()) {
	        	System.out.println(itr.getKey()+" "+itr.getValue());
	        }

		
	}
}
