package com.HarinderKaur.learningSeleniuim;

import org.json.*;
import org.openqa.selenium.json.JsonException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JsonMap {

	public static void main(String[] args) throws IOException {

		// create a map object
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Harinder");
		map.put("role", "QA Engineer");
		map.put("age", "32");

		// create object mapper
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		// convert map to String
		String jsonString = mapper.writeValueAsString(map);

		// print json string
		System.out.println(jsonString);
		
		//convert json to map object
		Map<String,String> map1 = mapper.readValue(jsonString.getBytes(), Map.class);
		System.out.println("\nJSOn string to Java Map Object");
		
		//print the map
		for(Map.Entry<String, String> e: map1.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
		//map1.entrySet().forEach(System.out::println);
	}
}
