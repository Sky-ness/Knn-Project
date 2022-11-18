package model;

import java.lang.reflect.Field;

public class Test {
	public String testString;
	public int testInt;
	
	public Test(String testString, int testInt) {
		super();
		this.testString = testString;
		this.testInt = testInt;
	}

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
		Test test = new Test("parker",22);
		
	}

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public int getTestInt() {
		return testInt;
	}

	public void setTestInt(int testInt) {
		this.testInt = testInt;
	}
	
}
