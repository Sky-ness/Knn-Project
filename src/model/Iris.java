package model;

import com.opencsv.bean.CsvBindByName;

import util.IColumn;
import util.IPoint;
import util.IrisVariety;

public class Iris {
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
	
}
