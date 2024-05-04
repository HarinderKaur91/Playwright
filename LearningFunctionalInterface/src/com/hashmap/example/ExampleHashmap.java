package com.hashmap.example;

import java.util.HashMap;

public class ExampleHashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		hm.put("Harinder", 50);
		hm.put("Navjot", 150);
		hm.put("Sanil", 250);
		hm.put("Kuldeep", 350);
		hm.put("Sahib", 450);
		hm.put("Swaroop", 550);
		
		hm.entrySet().stream().filter(p->p.getValue()>275).forEach(s->System.out.println(s.getKey()));



	}

}
