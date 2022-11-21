package model;

import java.util.List;

import utils.Classifier;
import utils.IPoint;

public class Robustesse {
	
	public double calc(DataSet ds, int k, Classifier classifier, Distance distance, Column col) {
		Object value;
		double i = 0.0;
		List<IPoint> neighbor;
		for(IPoint point : ds.getListePoints()) {
			neighbor = classifier.neighbor(k, point, distance, ds.getListePoints(), ds.getListeColumns());
			value = classifier.classify(neighbor,col);
			if(value.equals(point.getValue(col))){
				i++;
			}
		}
		return i/(ds.getNbLines()+0.0);
	}

	
}
