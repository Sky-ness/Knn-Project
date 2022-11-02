package model;

import utils.IDistance;
import utils.IPoint;

public class DistanceIris implements IDistance{



	@Override
	public double distanceEuclidienne(IPoint i1, IPoint i2) {
		((Iris) i1).getSepaiLength();
		return 0;
	}

	@Override
	public double distanceManhattan(IPoint i1, IPoint i2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
