package model;


import java.util.ArrayList;
import java.util.List;

import utils.Classifieur;
import utils.IPoint;

public class Knn extends Classifieur{
	
	@Override
	public List<IPoint> neighbor(int k, IPoint point, Distance distance,List<IPoint> list,List<Column> c1) {
		List<IPoint> test= new ArrayList<IPoint>();
		list.sort((i1,i2) -> {
			try {
				return Double.compare(distance.distanceManhattan(i1,point,c1), distance.distanceManhattan(i2, point,c1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return k;
		});
		for(int i = 0; i < k; i++) {
			test.add(list.get(i));
		}
		return test;
	}


}
