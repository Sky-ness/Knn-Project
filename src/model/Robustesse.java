package model;

import java.util.List;

import utils.Classifier;
import utils.IPoint;

public class Robustesse {
	
	public double calc(DataSet ds, int k, Classifier classifier, Distance distance, Column col) {
		Object value;
		double i = 0.0;
		List<IPoint> neighbor;
		List<IPoint> list = ds.getListePoints();
		System.out.println("1");
		for(int j = 0; j<list.size();j++) {
			neighbor = classifier.neighbor(k,list.get(j), distance, ds.getListePoints(), ds.getListeColumns());
			System.out.println(j);
			value = classifier.classify(neighbor,col);
			System.out.println("test : "+list.get(j).getValue(col) + " " + value);
			if(value.equals(list.get(j).getValue(col))){
				
				i++;
				
			}
		}
		return (i+0.0)/(ds.getNbLines()+0.0)*100;
	}

	public static void main(String[] args) {
		Parser parser = new Parser();
		parser.loadFromString("data/titanic.csv");
		Column col = parser.getDatas().getListeColumns().get(11);
		Robustesse rob = new Robustesse();
		System.out.println("Pourcentage : " + rob.calc(parser.datas,5,new Knn(),new Distance(),col));
		
		
	}
}
