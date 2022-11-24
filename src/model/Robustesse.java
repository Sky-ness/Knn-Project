package model;

import java.util.ArrayList;
import java.util.List;

import utils.AbstractClassifier;
import utils.IPoint;

public class Robustesse {
	
	@SuppressWarnings("PMD.ExcessiveParameterList")
	public double calc(Parser p, int k, AbstractClassifier classifier, Distance distance, Column col) {
		Object value;
		double i = 0.0;
		List<IPoint> neighbor;
		List<IPoint> list = init(ds);
		for(int j = 0; j<list.size();j++) {
			list = init(ds);
			neighbor = classifier.neighborManhattan(k,list.get(j), distance, list, ds.getListColumns());
			value = classifier.classify(neighbor,col);
			list = init(ds);
			if(value.equals(list.get(j).getValue(col))){
				
				i++;
				
			}
		}
		return (i+0.0)/(p.getNbLines()+0.0)*100;
	}
	
	public List<IPoint> init(DataSet ds){
		List<IPoint> list = new ArrayList<IPoint>();
		for(IPoint point : ds.getListPoints()) {
			list.add(point);
		}
		return list;
	}

	public static void main(String[] args) {
		Parser parser = new Parser();
		parser.loadFromString("data/titanic.csv");
		Column col = parser.getListColumns().get(11);
		Robustesse rob = new Robustesse();
		System.out.println("Pourcentage : " + rob.calc(parser.datas,5,new Knn(),new Distance(),col));
		
		
	}
}
