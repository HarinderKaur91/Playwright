package com.hashmap.Arrays;

import java.util.Arrays;

public class ExampleArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] no = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	
		//odd numbers using stream
		Arrays.stream(no).filter(p->p%2!=0).forEach(s->System.out.println(s));
	
		//evennumbers using stream and method reference
		Arrays.stream(no).filter(p->p%2==0).forEach(System.out::println);

	}

}
