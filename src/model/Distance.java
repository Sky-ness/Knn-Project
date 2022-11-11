package model;

import java.util.List;

import utils.IColumn;
import utils.IDistance;
import utils.IPoint;

public class Distance implements IDistance{

	@Override
	public double distanceEuclidienne(IPoint i1, IPoint i2,List<IColumn> c1) {
		double res = 0.0;
		for(IColumn icol:c1) {
			res += Math.abs(i1.getNormalizedValue(icol) - i2.getNormalizedValue(icol));
		}

		return res;
	}

	@Override
	public double distanceManhattan(IPoint i1, IPoint i2,List<IColumn> c1) {
		
		return 0;
	}

//	@Override
//	public double distanceEuclidienne(IPoint i1, IPoint i2, IColumn c1, IColumn c2) {
//		return Math.sqrt(Math.pow(i1.getNormalizedValue(c1) - i2.getNormalizedValue(c1), 2))
//				+ Math.sqrt(Math.pow(i1.getNormalizedValue(c2) - i2.getNormalizedValue(c2), 2));
//	}
//
//	@Override
//	public double distanceManhattan(IPoint i1, IPoint i2, IColumn c1, IColumn c2) {
//		return i1.getNormalizedValue(c1) - i2.getNormalizedValue(c1) 
//				+ i1.getNormalizedValue(c2) - i2.getNormalizedValue(c2);
//	}


}
