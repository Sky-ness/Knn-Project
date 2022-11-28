package model;

import java.lang.reflect.Field;

import com.opencsv.bean.CsvBindByName;

@SuppressWarnings("PMD.ShortClassName")
public class Iris extends IPoint {

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
	
	public Iris(String ...param) {

		try {
			sepalLength = Double.valueOf(param[0]);
		} catch (Exception e) {
			sepalLength = 0.0;
		}
		
		try {
			sepalWidth = Double.valueOf(param[1]);
		} catch (Exception e) {
			sepalWidth = 0.0;
		}
		
		try {
			petalLength = Double.valueOf(param[2]);
		} catch (Exception e) {
			petalLength = 0.0;
		}
		
		try {
			petalWidth = Double.valueOf(param[3]);
		} catch (Exception e) {
			petalWidth = 0.0;
		}
		
		String name = param[4].toLowerCase();
		if(name.contains("setosa")){
			variety=IrisVariety.SETOSA;
		} else if(name.contains("versicolor")){
			variety=IrisVariety.VERSICOLOR;
		} else if(name.contains("virginica")){
			variety=IrisVariety.VIRGINICA;
		} else {
			variety=null;
		}
		

	}

	@Override
	public String toString() {
		return "Iris [sepalLength=" + sepalLength + ", sepalWidth=" + sepalWidth + ", petalLength=" + petalLength
				+ ", petalWidth=" + petalWidth + ", variety=" + variety + "]";
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
	public Object getValue(Column col){
		Field[] fs = this.getClass().getDeclaredFields();
		String colName = col.getName();
		for(Field f : fs) {
			if(colName.equals(f.getName())) {
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
