package model;

import java.lang.reflect.Field;

import com.opencsv.bean.CsvBindByName;

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
	
	
	

	public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, IrisVariety variety) {
		super();
		this.sepalLength = sepalLength;
		this.sepalWidth = sepalWidth;
		this.petalLength = petalLength;
		this.petalWidth = petalWidth;
		this.variety = variety;
	}
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
	public Object getValue(Column col){
		Field[] fs = this.getClass().getDeclaredFields();
		for(Field f : fs) {
			if(f.getName().equals(col.getName())){
				try {
					return f.get(this);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	@Override
	public double getNormalizedValue(Column xcol){
		return xcol.getNormalizedValue(this);
	}
}
