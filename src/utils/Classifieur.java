package utils;

import java.util.List;

import model.Column;
import model.Distance;
import model.Parser;

public abstract class Classifieur {
	
	protected Parser parser;
	
	//public abstract List<IPoint> neighbor(int k,IPoint point, IDistance distance, List<IPoint> list,IColumn c1,IColumn c2);

	public abstract List<IPoint> neighbor(int k, IPoint point, Distance distance, List<IPoint> list, List<Column> c1);
		
	
}
