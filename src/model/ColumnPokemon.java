package model;

import utils.IColumn;
import utils.IDataset;
import utils.IPoint;
import utils.IValueNormalizer;

public class ColumnPokemon extends AbstractColumn{

	protected String name;
	protected DataSet dataset;
	protected IValueNormalizer normaliseur;

	public ColumnPokemon(String name, DataSet dataset, IValueNormalizer normaliseur) {
		super();
		this.name = name;
		this.dataset = dataset;
		this.normaliseur = normaliseur;
	}

	@Override
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		this.valueNormalizer = valueNormalizer;
	}

	@Override
	public String getName() {
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
