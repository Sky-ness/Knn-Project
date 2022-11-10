package utils;

import java.util.List;

public interface IDistance {
	
	public double distanceEuclidienne(IPoint i1, IPoint i2 /*List<Object> comparateur*/ );
	
	public double distanceManhattan(IPoint i1, IPoint i2 /*List<Object> comparateur*/);
}
