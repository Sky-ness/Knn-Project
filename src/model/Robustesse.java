package model;

import java.util.ArrayList;
import java.util.List;

import utils.AbstractClassifier;

public class Robustesse {
	
	@SuppressWarnings("PMD.ExcessiveParameterList")
	public double calc(Parser parser, int k, AbstractClassifier classifier, Column column,List<Column> listColumn) {
		Object value;
		double i = 0.0;
		List<AbstractPoint> neighbor;
		List<AbstractPoint> list = init(parser);
		for(int j = 0; j<list.size();j++) {
			list = init(parser);
			neighbor = classifier.neighborManhattan(k,list.get(j), list, listColumn);
			value = classifier.classify(neighbor,column);
			list = init(parser);
			if(value.equals(list.get(j).getValue(column))){
				i++;
				
			}
		}
		return (i+0.0)/(parser.getNbLines()+0.0)*100;
	}
	
	
	
	
	public List<AbstractPoint> init(Parser p){
		List<AbstractPoint> list = new ArrayList<AbstractPoint>();
		for(AbstractPoint point : p.getListPoints()) {
			list.add(point);
		}
		return list;
	}
}
