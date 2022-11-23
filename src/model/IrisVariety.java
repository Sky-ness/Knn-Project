package model;

public enum IrisVariety {
	SETOSA(1), VERSICOLOR(2), VIRGINICA(3);
	
	private int value;
	
	IrisVariety(int i) {
		value = i;
	}
	
	public int getValue() {
		return value;
	}
}
