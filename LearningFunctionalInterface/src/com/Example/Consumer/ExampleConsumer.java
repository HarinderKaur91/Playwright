package com.Example.Consumer;

import java.util.function.Consumer;

public class ExampleConsumer {

	public static void main(String[] args) {
		
		//Implementation using lambda
		Consumer<String> consumer = (String s) -> System.out.println(s);
		consumer.accept("Harinder");
	}
	
	//Old implementation
	public void printSomething(String s) {
		System.out.println(s.contains("a"));
	}
}
