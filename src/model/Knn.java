package model;


import java.util.ArrayList;
import java.util.List;

import utils.Classifieur;
import utils.IDistance;
import utils.IPoint;

public class Knn implements Classifieur{
	
	List<IPoint> test;

	@Override
	public List<IPoint> neighbor(int k, IPoint point, IDistance distance) {
		List<IPoint> listPoint = new ArrayList<>();
		test.sort((p1,p2) -> Double.compare(distance.distanceManhattan(p1,point), distance.distanceManhattan(p2, point)));
		for(int i = 0; i < k; i++) {
			listPoint.add(test.get(i));
		}
		return listPoint;
	}

}
