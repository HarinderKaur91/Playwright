package com.learning.singleton;

public class DemoSingletonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingletonExample instaExample1 = SingletonExample.getInstance();
		instaExample1.test1();

		SingletonExample instaExample2 = SingletonExample.getInstance();
		System.out.println(instaExample2);

	}

}
