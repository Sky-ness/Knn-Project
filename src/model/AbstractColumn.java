package model;

import utils.IDataset;
import utils.IPoint;
import utils.IValueNormalizer;

public abstract class AbstractColumn {

	protected static IValueNormalizer valueNormalizer;
	protected String name;
	protected IDataset dataset;
	
	public AbstractColumn(String name, IDataset dataset) {
		this.name = name;
		this.dataset = dataset;
	}

	public void setNormalizer(IValueNormalizer valueNormalizer) {
		this.valueNormalizer = valueNormalizer;
	}

	public String getName() {
		return name;
	}

	public IDataset getDataset() {
		return dataset;
	}
	
	public boolean isNormalizable() {
		return valueNormalizer!=null;
	}
	
	public double getNormalizedValue(IPoint point) {
		if(isNormalizable())
			return valueNormalizer.normalize(point);
		return -1.0;
	}

	public Object getDenormalizedValue(double value) {
		if(isNormalizable())
			return valueNormalizer.denormalize(value);
		return -1.0;
	}

}
