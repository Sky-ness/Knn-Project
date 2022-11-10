package model;

import utils.IColumn;
import utils.IDistance;
import utils.IPoint;

public class Distance implements IDistance{

	@Override
	public double distanceEuclidienne(IPoint i1, IPoint i2, IColumn c1, IColumn c2) {
		return Math.sqrt(Math.pow(i1.getNormalizedValue(c1) - i2.getNormalizedValue(c1), 2))
				+ Math.sqrt(Math.pow(i1.getNormalizedValue(c2) - i2.getNormalizedValue(c2), 2));
	}

	@Override
	public double distanceManhattan(IPoint i1, IPoint i2, IColumn c1, IColumn c2) {
		return i1.getNormalizedValue(c1) - i2.getNormalizedValue(c1) 
				+ i1.getNormalizedValue(c2) - i2.getNormalizedValue(c2);
	}


}
