package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.AbstractClassifier;
import utils.IPoint;

public class Randomizer extends AbstractClassifier {

	

	@Override
	public List<IPoint> neighborEuclidienne(int k, IPoint point, Distance distance, List<IPoint> list,
			List<Column> c1) {
		List<IPoint> res = new ArrayList<IPoint>();
		Collections.shuffle(list);

		for(int i=0;i<k;i++) {
			res.add(list.get(i));
		}
		return res;
	}

	@Override
	public List<IPoint> neighborManhattan(int k, IPoint point, Distance distance, List<IPoint> list, List<Column> c1) {
		List<IPoint> res = new ArrayList<IPoint>();
		Collections.shuffle(list);

		for(int i=0;i<k;i++) {
			res.add(list.get(i));
		}
		return res;
	}


}
