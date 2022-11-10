package model;


import java.util.ArrayList;
import java.util.List;

import utils.Classifieur;
import utils.IDistance;
import utils.IPoint;

public class Knn extends Classifieur{
	
	List<IPoint> test;

	@Override
	public List<IPoint> neighbor(int k, IPoint point, IDistance distance,List<IPoint> list) {
		test.sort((i1,i2) -> Double.compare(distance.distanceManhattan(i1,point), distance.distanceManhattan(i2, point)));
		for(int i = 0; i < k; i++) {
			list.add(test.get(i));
		}
		return list;
	}

}
