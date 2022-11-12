package model;

import utils.IColumn;
import utils.IDataset;
import utils.IPoint;
import utils.IValueNormalizer;

public abstract class AbstractColumn implements IColumn{

	protected static IValueNormalizer valueNormalizer;
	
	/*
	 * abstract car chaque colonne a un normalizer different
	 */
	public abstract void setNormalizer(IValueNormalizer valueNormalizer);
	/*
	 * abstract car chaque colonne a un nom  
	 */
	public abstract String getName();
	/*
	 * le dataSet je sais pas ce qu'il fout la
	 */
	public abstract IDataset getDataset();
	
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
