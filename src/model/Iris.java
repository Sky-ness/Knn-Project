package model;

import java.lang.reflect.Field;

import com.opencsv.bean.CsvBindByName;

import utils.IColumn;
import utils.IPoint;

public class Iris implements IPoint {

	@CsvBindByName(column = "sepal.length")
	private double sepalLength;
	@CsvBindByName(column = "sepal.width")
	private double sepalWidth;
	@CsvBindByName(column = "petal.length")
	private double petalLength;
	@CsvBindByName(column = "petal.width")
	private double petalWidth;
	@CsvBindByName(column = "variety")
	private IrisVariety variety;

	public double getSepalLength() {
		return sepalLength;
	}
	public double getSepalWidth() {
		return sepalWidth;
	}
	public double getPetalLength() {
		return petalLength;
	}
	public double getPetalWidth() {
		return petalWidth;
	}
	public IrisVariety getVariety() {
		return variety;
	}
	@Override
	public String toString() {
		return "Iris [sepalLength=" + sepalLength + ", sepaiWidth=" + sepalWidth + ", petalLength=" + petalLength
				+ ", petalWidth=" + petalWidth + ", variety=" + variety + "]";
	}
	
	@Override
	public Object getValue(Column col) throws IllegalArgumentException, IllegalAccessException{
		Field[] fs = this.getClass().getFields();
		for(Field f : fs) {
			if(f.getName().equals(col.getName())){
				return f.get(this);
			}
		}
		return null;
		/*
		switch(col.getName()) {
		case "sepalLength":
			return sepalLength;
		case "sepalWidth":
			return sepalWidth;
		case "petalLength":
			return petalLength;
		case "petalWidth":
			return petalWidth;
		case "variety":
			return variety;
		default:
			return null;
		}
		*/
	}
	@Override
	public double getNormalizedValue(Column xcol) throws Exception {
		return xcol.getNormalizedValue(this);
	}

}
