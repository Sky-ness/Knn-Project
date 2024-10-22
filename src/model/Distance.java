package model;

import java.util.List;

public class Distance{

	public double distanceEuclidienne(IPoint point1, IPoint point2,List<Column> columns){
		double res = 0.0;
		for(Column icol:columns) {
			res += 	Math.sqrt(Math.pow(Math.abs(point1.getNormalizedValue(icol) - point2.getNormalizedValue(icol)+ 0.0), 2));
		}

		return res;
	}

	public double distanceManhattan(IPoint point1, IPoint point2,List<Column> columns) {
		double res = 0.0;
		for(Column icol:columns) {
			res += Math.abs(point1.getNormalizedValue(icol) - point2.getNormalizedValue(icol));
		}

		return res;
	}
	


}
