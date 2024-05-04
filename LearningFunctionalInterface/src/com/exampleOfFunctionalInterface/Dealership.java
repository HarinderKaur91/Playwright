package com.exampleOfFunctionalInterface;

@FunctionalInterface
public interface Dealership {

	// abstract method

	public void verifyVin();

	//static method
	public static void itsStatic() {
		System.out.println("This is a static method inside Interface");
	}
	
	//default method
	public  default void itsDefault() {
		System.out.println("This is a default method");
	}

}
