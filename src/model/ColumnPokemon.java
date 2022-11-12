package model;

import utils.IColumn;
import utils.IDataset;
import utils.IPoint;
import utils.IValueNormalizer;

public class ColumnPokemon extends AbstractColumn{

	private String name;

	@Override
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
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
