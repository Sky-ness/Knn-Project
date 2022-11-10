package model;

import java.lang.reflect.Field;

public class Test {
	public String testString = "paker";
	public int testInt = 22;
	
	public Object searchAttributes(String name) throws IllegalArgumentException, IllegalAccessException {
		Field[] fs = this.getClass().getFields();
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
