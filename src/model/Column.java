package model;

import java.lang.reflect.Field;

import utils.IValueNormalizer;

public class Column {

	protected IValueNormalizer valueNormalizer;
	protected String name;
	protected DataSet dataset;
	
	public Column(String name, DataSet dataset) {
		this.name = name;
		this.dataset = dataset;
		this.valueNormalizer = null;
	}
	/*
	 * abstract car chaque colonne a un normalizer different
	 */
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		this.valueNormalizer = valueNormalizer;
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
	
	public IValueNormalizer getValueNormalizer() {
		return valueNormalizer;
	}
	
	public void setValueNormalizer(IValueNormalizer valueNormalizer) {
		this.valueNormalizer = valueNormalizer;
	}
	
	public boolean isNormalizable() {
		return valueNormalizer!=null;
	}
	
	public double getNormalizedValue(IPoint point){
		if(!isNormalizable()) {
			return 0.0;
		}
		double result = 0.0;
		Class<? extends IPoint> pt = point.getClass();
		for(Field field : pt.getDeclaredFields()) {
			if(this.name.equals(field.getName())) {
				try {
					result = valueNormalizer.normalize(field.get(point));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public Object getDenormalizedValue(double value){
		if(isNormalizable())
			return valueNormalizer.denormalize(value);
		return 0.0;
	}
	@Override
	public String toString() {
		return "Column name=" + name;
	}
}
