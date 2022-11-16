package model;

import utils.IColumn;
import utils.IDataset;
import utils.IPoint;
import utils.IValueNormalizer;

public class ColumnPokemon implements IColumn{

	protected List<IColumn> listColumn;
	@Override
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getNormalizedValue(IPoint point) {
		
		return point.getValue(this);
	}

	@Override
	public Object getDenormalizedValue(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDataset getDataset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNormalizable() {
		// TODO Auto-generated method stub
		return false;
	}

}
