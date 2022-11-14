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
			res += 	Math.sqrt(Math.pow(Math.abs(i1.getNormalizedValue(icol) - i2.getNormalizedValue(icol)+ 0.0), 2));

		}
		
		
		return res;
	}

	@Override
	public double distanceManhattan(IPoint i1, IPoint i2,List<IColumn> c1) {
		double res = 0.0;
		for(IColumn icol:c1) {
			res += Math.abs(i1.getNormalizedValue(icol) - i2.getNormalizedValue(icol));
		}

		return res;
	}
	


}
