package model;

import java.lang.reflect.Field;

import com.opencsv.bean.CsvBindByName;

import utils.IPoint;

public class Iris implements IPoint {

	@CsvBindByName(column = "sepal.length")
	protected double sepalLength;
	@CsvBindByName(column = "sepal.width")
	protected double sepalWidth;
	@CsvBindByName(column = "petal.length")
	protected double petalLength;
	@CsvBindByName(column = "petal.width")
	protected double petalWidth;
	@CsvBindByName(column = "variety")
	protected IrisVariety variety;
	
	public Iris() {
		
	}
	
	public Iris(Object ...objects) {
		sepalLength = Double.valueOf((String)objects[0]);
		sepalWidth = Double.valueOf((String)objects[1]);
		petalLength = Double.valueOf((String)objects[2]);
		petalWidth = Double.valueOf((String)objects[3]);
		

		String name = ((String)objects[4]).toLowerCase();
		if(name.contains("setosa")){
			variety=IrisVariety.Setosa;
		} else if(name.contains("versicolor")){
			variety=IrisVariety.Versicolor;
		} else if(name.contains("virginica")){
			variety=IrisVariety.Virginica;
		} else {
			variety=null;
		}
		

	}
	
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
