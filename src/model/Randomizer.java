package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.AbstractClassifier;

public class Randomizer extends AbstractClassifier {

	@Override
	public List<IPoint> neighborEuclidienne(int k, IPoint point, List<IPoint> points,
			List<Column> columns) {
		List<IPoint> res = new ArrayList<IPoint>();
		Collections.shuffle(points);

		for(int i=0;i<k;i++) {
			res.add(points.get(i));
		}
		return res;
	}

	@Override
	public List<IPoint> neighborManhattan(int k, IPoint point, List<IPoint> points, List<Column> columns) {
		List<IPoint> res = new ArrayList<IPoint>();
		Collections.shuffle(points);

		for(int i=0;i<k;i++) {
			res.add(points.get(i));
		}
		return res;
	}


}
