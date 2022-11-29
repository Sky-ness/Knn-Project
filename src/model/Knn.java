package model;


import java.util.ArrayList;
import java.util.List;

import utils.AbstractClassifier;

@SuppressWarnings("PMD.ShortClassName")
public class Knn extends AbstractClassifier{
	

	@Override
	@SuppressWarnings("PMD.ExcessiveParameterList")
	public List<IPoint> neighborManhattan(int k, IPoint point, List<IPoint> list, List<Column> c1) {
		List<IPoint> result= new ArrayList<IPoint>();
		Distance distance = new Distance();
		list.sort((i1,i2) -> Double.compare(distance.distanceManhattan(i1,point,c1), distance.distanceManhattan(i2, point,c1)));
		for(int i = 0; i < k+1; i++) {
			result.add(list.get(i));
		}
		return result;
	}

	@Override
	@SuppressWarnings("PMD.ExcessiveParameterList")
	public List<IPoint> neighborEuclidienne(int k, IPoint point, List<IPoint> list, List<Column> c1) {
		List<IPoint> result= new ArrayList<IPoint>();
		Distance distance = new Distance();
		list.sort((i1,i2) -> Double.compare(distance.distanceEuclidienne(i1,point,c1), distance.distanceEuclidienne(i2, point,c1)));
		for(int i = 0; i < k+1; i++) {
			result.add(list.get(i));
		}
		return result;
	}
	
}
