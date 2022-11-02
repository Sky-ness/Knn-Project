package utils;

import java.util.List;

public interface Classifieur {
	
	public List<IPoint> neighbor(int k,IPoint point, IDistance distance);
	
	
		
	
}
