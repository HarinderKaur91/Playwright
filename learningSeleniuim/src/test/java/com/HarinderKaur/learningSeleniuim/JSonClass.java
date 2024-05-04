package com.HarinderKaur.learningSeleniuim;


	import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

	public class JSonClass {

	    public Map<String, String> getIdNameMap(JSONObject jsonObj) {
	        Map<String, String> idNameMap = new HashMap<>();
	        
	        idNameMap = new Gson().fromJson(jsonObj.toString(),HashMap.class);
	        
//	        for(Map.Entry<String, String> itr: map.entrySet()) {
//	        	System.out.println(itr.getKey()+" "+itr.getValue());
//	        }

//	        // Extract id and name attributes from the JSONObject
//	        String id = jsonObj.getString("id");
//	        String name = jsonObj.getString("name");

	        // Add id and name to the idNameMap
	    //    idNameMap.put(id, name);

	        return idNameMap;
	    }
	}

