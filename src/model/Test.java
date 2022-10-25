package model;

import main.main;

public class Test {
	private String test = "test";
	
	public void meth() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		System.out.println(Test.class.getField("test").get(this));
	}
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Test test = new Test();
		test.meth();
	}
}
