package com.exampleOfFunctionalInterface;

public class ExampleMain {

	public static void main(String[] args) {

		Dealership ds = new Honda();
		ds.verifyVin();
		
		// we can call default method using reference variable of interface
		ds.itsDefault();
		//we can call static method using interface name
		Dealership.itsStatic();

		Dealership ds1 = new Dealership()  {

			@Override
			public void verifyVin() {
				System.out.println("verify VIN in Main class");
			}
		};
		ds1.verifyVin();
				
		Dealership ds2=()->System.out.println("Verify VIn using lambda");
		ds2.verifyVin();
	}

}
