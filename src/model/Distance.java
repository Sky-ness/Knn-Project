package model;

import java.util.List;

import utils.IPoint;

public class Distance{

	public double distanceEuclidienne(IPoint i1, IPoint i2,List<Column> c1){
		double res = 0.0;
		for(Column icol:c1) {
			res += 	Math.sqrt(Math.pow(Math.abs(i1.getNormalizedValue(icol) - i2.getNormalizedValue(icol)+ 0.0), 2));

		}
		
		
		return res;
	}

	public double distanceManhattan(IPoint i1, IPoint i2,List<Column> c1) {
		double res = 0.0;
		for(Column icol:c1) {
			res += Math.abs(i1.getNormalizedValue(icol) - i2.getNormalizedValue(icol));
		}

		return res;
	}
	


}
