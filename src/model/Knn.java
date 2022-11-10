package model;


import java.util.List;

import utils.Classifieur;
import utils.IColumn;
import utils.IDistance;
import utils.IPoint;

public class Knn extends Classifieur{
	
	List<IPoint> test;

	@Override
	public List<IPoint> neighbor(int k, IPoint point, IDistance distance,List<IPoint> list,IColumn c1,IColumn c2) {
		test.sort((i1,i2) -> Double.compare(distance.distanceManhattan(i1,point,c1,c2), distance.distanceManhattan(i2, point,c1,c2)));
		for(int i = 0; i < k; i++) {
			list.add(test.get(i));
		}
		return list;
	}

}
