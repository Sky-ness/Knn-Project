package utils;

import java.util.List;

import model.Column;
import model.IPoint;
import model.NullObject;

public abstract class AbstractClassifier {

	public abstract List<IPoint> neighborManhattan(int k, IPoint point, List<IPoint> list, List<Column> c1);
	
	public abstract List<IPoint> neighborEuclidienne(int k, IPoint point, List<IPoint> list, List<Column> c1);
	
	public Object classify(List<IPoint> neighbor, Column col){
		Object value;
		int i = 0; int max = 0;
		Object valueFound = neighbor.get(1);
		for(int j = 1 ; j < neighbor.size() ; j++) {
			value = neighbor.get(j).getValue(col);
			i = 0;
			for(IPoint pointCompare  : neighbor) {
				if(value == null) {
					value = new NullObject();
				}
				if(value.equals(pointCompare.getValue(col))) {
					i++;
					if(i>max){
						max = i ;
						valueFound = value;
					}
				}
			}
		}
		return valueFound;
	}
	
		
	
}
