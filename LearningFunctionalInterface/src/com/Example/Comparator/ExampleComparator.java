package com.Example.Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ExampleComparator {
	
	public static void main(String[] args) {
		
		List<String> myList = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight");
		
		//Lexicographic comparison
		Comparator<String> comparatorLexico=(s1,s2)->s1.compareTo(s2);
		myList.sort(comparatorLexico);
		System.out.println(myList);
		
		//Comaprison based on Length
		Comparator<String> comparatorLength =(s1,s2)->Integer.compare(s1.length(), s2.length());
		myList.sort(comparatorLength);
		System.out.println(myList);
		
		//Comparison based on lenght-2
		Function<String, Integer> function=(String s)->s.length();
		Comparator<String> comparatorLength2=Comparator.comparing(function);
	
		
		myList.sort(comparatorLength2.reversed());
		System.out.println(myList);
		
		
		User harinder = new User("Harinder", 31);
		User manvir = new User("Manvir",34);
		User navjot = new User("Navjot",25);
		User swaroop = new User("Swaroop",36);
		
		List<User> userList = Arrays.asList(harinder,manvir,navjot,swaroop);
		
		//Function<User, String> function2=user->user.getName();
		//comparison based upon name
		Comparator<User> compName = Comparator.comparing(user->user.getName());
		userList.sort(compName);
		userList.forEach(user->System.out.println(user.getName()));
		
		//sorting names based upon age
		Comparator<User> compAge=Comparator.comparing(user->user.getAge());
		userList.sort(compAge);
		userList.forEach(user->System.out.println(user.getName()));
		
		userList.sort(compName.thenComparing(compAge));
		userList.sort(compAge);
		userList.forEach(user->System.out.println(user.getName()));	
		
	}

}
