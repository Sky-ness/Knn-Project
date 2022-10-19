package model.enums;

public enum IrisVariety {
	Setosa(1), Versicolor(2), Virginica(3);
	
	private int value;
	
	IrisVariety(int i) {
		value = i;
	}
	
	public int getValue() {
		return value;
	}
}
