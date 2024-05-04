package com.Example.Supplier;

import java.util.function.Supplier;

public class ExampleSupplier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Supplier<String> supplier=()->"Hello".toUpperCase();
		System.out.println(supplier.get());
		
	}

}
