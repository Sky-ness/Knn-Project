package model;


import java.util.ArrayList;
import java.util.List;

import utils.Classifier;
import utils.IPoint;

public class Knn extends Classifier{
	
	@Override
	public List<IPoint> neighbor(int k, IPoint point, Distance distance,List<IPoint> list,List<Column> c1) {
		List<IPoint> test= new ArrayList<IPoint>();
		list.sort((i1,i2) -> Double.compare(distance.distanceManhattan(i1,point,c1), distance.distanceManhattan(i2, point,c1)));
		for(int i = 0; i < k; i++) {
			test.add(list.get(i));
		}
		return test;
	}

}
