package model;

import java.lang.reflect.Field;

public class Test {
	private String testString = "paker";
	private int testInt = 22;
	
	public Object searchAttributes(String name) throws IllegalArgumentException, IllegalAccessException {
		Field[] fs = this.getClass().getDeclaredFields();
		for(Field f : fs) {
			if(f.getName().equals(name)){
				return f.get(this);
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Test test = new Test();
		System.out.println(test.searchAttributes("testString"));
		
	}
}
