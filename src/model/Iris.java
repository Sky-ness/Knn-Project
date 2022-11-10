package model;

import com.opencsv.bean.CsvBindByName;

import utils.IColumn;
import utils.IPoint;

public class Iris implements IPoint {

	@CsvBindByName(column = "sepal_length")
	private double sepalLength;
	@CsvBindByName(column = "sepal_width")
	private double sepalWidth;
	@CsvBindByName(column = "petal_length")
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
	public Object getValue(IColumn col) {
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
	}
	@Override
	public double getNormalizedValue(IColumn xcol) {
		if(xcol.isNormalizable()) {
			return xcol.getNormalizedValue(this);
		}
		return 0.0;
	}

}
