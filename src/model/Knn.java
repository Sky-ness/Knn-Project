package model;


import java.util.ArrayList;
import java.util.List;

import utils.AbstractClassifier;

@SuppressWarnings("PMD.ShortClassName")
public class Knn extends AbstractClassifier{
	

	@Override
	@SuppressWarnings("PMD.ExcessiveParameterList")
	public List<IPoint> neighborManhattan(int k, IPoint point, List<IPoint> listPoint, List<Column> columns) {
		List<IPoint> result= new ArrayList<IPoint>();
		Distance distance = new Distance();
		listPoint.sort((i1,i2) -> Double.compare(distance.distanceManhattan(i1,point,columns), distance.distanceManhattan(i2, point,columns)));
		for(int i = 0; i < k+1; i++) {
			result.add(listPoint.get(i));
		}
		return result;
	}

	@Override
	@SuppressWarnings("PMD.ExcessiveParameterList")
	public List<IPoint> neighborEuclidienne(int k, IPoint point, List<IPoint> listPoint, List<Column> columns) {
		List<IPoint> result= new ArrayList<IPoint>();
		Distance distance = new Distance();
		listPoint.sort((i1,i2) -> Double.compare(distance.distanceEuclidienne(i1,point,columns), distance.distanceEuclidienne(i2, point,columns)));
		for(int i = 0; i < k+1; i++) {
			result.add(listPoint.get(i));
		}
		return result;
	}
	
}
