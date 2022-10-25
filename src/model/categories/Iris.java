package model.categories;

import com.opencsv.bean.CsvBindByName;

import model.abstracts.Point;
import model.enums.IrisVariety;
import util.IColumn;
import util.IPoint;

public class Iris  {
	@CsvBindByName(column = "sepai_length")
	private double sepaiLength;
	@CsvBindByName(column = "sepai_width")
	private double sepaiWidth;
	@CsvBindByName(column = "petal_length")
	private double petalLength;
	@CsvBindByName(column = "petal_width")
	private double petalWidth;
	@CsvBindByName(column = "variety")
	private IrisVariety variety;
	
	public double getSepaiLength() {
		return sepaiLength;
	}
	public double getSepaiWidth() {
		return sepaiWidth;
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
		return "Iris [sepaiLength=" + sepaiLength + ", sepaiWidth=" + sepaiWidth + ", petalLength=" + petalLength
				+ ", petalWidth=" + petalWidth + ", variety=" + variety + "]";
	}
	@Override
	public Object getValue(IColumn col) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getNormalizedValue(IColumn xcol) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
