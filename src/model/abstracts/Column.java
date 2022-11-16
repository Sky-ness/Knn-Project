package model.abstracts;

import util.IColumn;
import util.IDataset;
import util.IPoint;
import util.IValueNormalizer;

public abstract class Column implements IColumn{
	
	private IValueNormalizer ivn;
	private String name;
	private IDataset dataset;
	private boolean normalizable;

	public Column(IValueNormalizer ivn, String name, IDataset dataset, boolean normalizable) {
		this.ivn = ivn;
		this.name = name;
		this.dataset = dataset;
		this.normalizable = normalizable;
	}

	@Override
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		ivn = valueNormalizer;
	}

	@Override
	public double getNormalizedValue(IPoint point) {
		return ivn.normalize(point);
	}

	@Override
	public Object getDenormalizedValue(double value) {
		return ivn.denormalize(value);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IDataset getDataset() {
		return dataset;
	}

	@Override
	public boolean isNormalizable() {
		return normalizable;
	}

}
