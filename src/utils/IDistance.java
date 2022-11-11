package utils;

import java.util.List;

public interface IDistance {
	
//	public double distanceEuclidienne(IPoint i1, IPoint i2,IColumn c1,IColumn c2 );
//	
//	public double distanceManhattan(IPoint i1, IPoint i2, IColumn c1,IColumn c2);
	
	public double distanceEuclidienne(IPoint i1, IPoint i2,List<IColumn> c1);
	
	public double distanceManhattan(IPoint i1, IPoint i2,List<IColumn> c1);
}
