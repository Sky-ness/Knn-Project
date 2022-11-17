package model;

import utils.IPoint;
import utils.IValueNormalizer;

public class Column {

	protected static IValueNormalizer valueNormalizer;
	protected String name;
	protected DataSet dataset;
	
	public Column(String name, DataSet dataset) {
		this.name = name;
		this.dataset = dataset;
	}
	/*
	 * abstract car chaque colonne a un normalizer different
	 */
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		Column.valueNormalizer = valueNormalizer;
	}
	/*
	 * abstract car chaque colonne a un nom  
	 */
	public String getName() {
		return name;
	}
	/*
	 * le dataSet je sais pas ce qu'il fout la
	 */
	public DataSet getDataset() {
		return dataset;
	}
	
	public boolean isNormalizable() {
		return valueNormalizer!=null;
	}
	
	public double getNormalizedValue(IPoint point){
		if(isNormalizable())
			return valueNormalizer.normalize(point);
		return -1.0;
	}

	public Object getDenormalizedValue(double value){
		if(isNormalizable())
			return valueNormalizer.denormalize(value);
		return -1.0;
	}


}
