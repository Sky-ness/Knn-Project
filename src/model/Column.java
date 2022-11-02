package model;

import utils.IColumn;
import utils.IDataset;
import utils.IPoint;
import utils.IValueNormalizer;

public class Column implements IColumn {
	protected String name;
	protected IValueNormalizer valueNormalizer;

	public Column(String name, IValueNormalizer valueNormalizer) {
		super();
		this.name = name;
		this.valueNormalizer = valueNormalizer;
	}

	@Override
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		this.valueNormalizer = valueNormalizer;
	}

	@Override
	public double getNormalizedValue(IPoint point) {
		return this.valueNormalizer.normalize(point);
	}

	@Override
	public Object getDenormalizedValue(double value) {
		return this.valueNormalizer.denormalize(value);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IDataset getDataset() {
		return null;
	}

	@Override
	public boolean isNormalizable() {
		return (this.valueNormalizer.equals(null));
	}

}
