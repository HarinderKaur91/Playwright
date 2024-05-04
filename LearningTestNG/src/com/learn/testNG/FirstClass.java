package com.learn.testNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstClass {

	@BeforeClass
	public void installTestNG() {
		System.out.println("Installing Test NG");
	}

	@AfterClass
	public void installedTestNG() {
		System.out.println("Installed Test NG");
	}

	@BeforeTest
	public void doSomething() {
		System.out.println("Learning Test NG annotations");
	}

//	@BeforeTest	
//	public void startIgnition() {
//		System.out.println("Car has been started");
//	}
//		@Test	
//	public void testSomething() {
//		System.out.println("Car running for testing");
//	}
//	@AfterTest
//	public void stopTheCar() {
//		System.out.println("Car stopped");
//	}
	@BeforeMethod
	public void openBrowser() {
		System.out.println("Open browser and load base URL");
	}

	@Test(priority = 1)
	public void test1() {
		System.out.println("Run test1");
	}

	@Test(dependsOnMethods = { "test3" }) // test3 will run first then test2 will run
	public void test2() {
		SoftAssert sfAssert = new SoftAssert();
		System.out.println("Run test2");
		boolean isTrue = false;
		// Assert.assertTrue(isTrue);
		sfAssert.assertTrue(isTrue);

		System.out.println("This is line 55");

		// Assert.assertEquals("My name is Harinder", "My name is Amar", "Amar is
		// expected");
		sfAssert.assertEquals("My name is Harinder", "My name is Amar", "Amar is  expected");
		sfAssert.assertAll();
		// Assert.assertNotEquals();
	}

	@Test
	public void test3() {
		System.out.println("Run test3");
	}

	@Test(dependsOnMethods = { "test5" })
	public void test4() {
		System.out.println("Run test4");
	}

	@Test
	public void test5() {
		System.out.println("Run test5");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("Close the browser");
	}

	@AfterTest
	public void doSomethingBeforeClosing() {
		System.out.println("Learnt Annotations");

	}
}
