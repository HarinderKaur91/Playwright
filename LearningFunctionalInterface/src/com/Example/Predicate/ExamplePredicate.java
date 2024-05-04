package com.Example.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExamplePredicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Predicate<String> predicate = (String s) -> s.contains("kaur");
		boolean val = predicate.test("harinder kaur");
		System.out.println(val);

		List<String> myList = new ArrayList<>(List.of("one", "two", "three", "four", "five"));
		// we want to filter out strings which contains 'o' in it

		Predicate<String> pre = (String s) -> s.contains("o");
		myList.removeIf(pre);

		//Consumer<String> consumer = (String s) -> System.out.println(s.toUpperCase());
		Consumer<String> consumer = s -> System.out.println(s.toUpperCase());

		myList.forEach(consumer);
		
	}
}
