package model;

import java.util.ArrayList;
import java.util.List;

import utils.AbstractClassifier;

public class Robustesse {
	
	@SuppressWarnings("PMD.ExcessiveParameterList")
	public double calc(Parser p, int k, AbstractClassifier classifier, Column col) {
		Object value;
		double i = 0.0;
		List<IPoint> neighbor;
		List<IPoint> list = init(p);
		for(int j = 0; j<list.size();j++) {
			list = init(p);
			neighbor = classifier.neighborManhattan(k,list.get(j), list, p.getListColumns());
			value = classifier.classify(neighbor,col);
			list = init(p);
			if(value.equals(list.get(j).getValue(col))){
				i++;
				
			}
		}
		return (i+0.0)/(p.getNbLines()+0.0)*100;
	}
	
	public List<IPoint> init(Parser p){
		List<IPoint> list = new ArrayList<IPoint>();
		for(IPoint point : p.getListPoints()) {
			list.add(point);
		}
		return list;
	}
}
