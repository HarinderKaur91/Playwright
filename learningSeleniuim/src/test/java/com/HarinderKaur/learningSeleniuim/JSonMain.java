package com.HarinderKaur.learningSeleniuim;

import java.util.Map;

import org.json.simple.JSONObject;

public class JSonMain {

	public static void main(String[] args) {
		// Create a sample JSONObject
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", "123");
		jsonObj.put("name", "John Doe");

		// Call the getIdNameMap method and store the result in a Map
		JSonClass myClass = new JSonClass();
		Map<String, String> idNameMap = myClass.getIdNameMap(jsonObj);

		// Print the contents of the idNameMap
		System.out.println("ID-Name Map:");
		for (Map.Entry<String, String> entry : idNameMap.entrySet()) {
			System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
		}
		
		
	}
}
