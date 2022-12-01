package utils;

import java.util.List;

import model.Column;
import model.AbstractPoint;
import model.NullObject;

public abstract class AbstractClassifier {

	public abstract List<AbstractPoint> neighborManhattan(int k, AbstractPoint point, List<AbstractPoint> list, List<Column> c1);
	
	public abstract List<AbstractPoint> neighborEuclidienne(int k, AbstractPoint point, List<AbstractPoint> list, List<Column> c1);
	
	public Object classify(List<AbstractPoint> neighbor, Column col){
		Object value;
		neighbor.remove(0);
		int i = 0; int max = 0;
		Object valueFound = neighbor.get(0);
		for(AbstractPoint point  : neighbor) {
			value = point.getValue(col);
			i = 0;
			for(AbstractPoint pointCompare  : neighbor) {
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
