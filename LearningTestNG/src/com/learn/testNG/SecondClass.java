package com.learn.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SecondClass {

	
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

}
