package model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.IDataset;
import utils.IPoint;

public class DataSet implements IDataset{

	protected String title;
	protected List<IPoint> listePoints;
	protected List<Column> listeColumns; 

	public DataSet(String title,List<IPoint> listePoints) {
		this.title=title;
		this.listePoints=listePoints;
		this.listeColumns=listColumn();
	}

	private List<Column> listColumn(){
		List<Column> list = new ArrayList<Column>();
		Column column = null;
		if(listePoints.size() == 0)
			return list;
		@SuppressWarnings("PMD.LawOfDemeter")
		Field[] fs = listePoints.get(0).getClass().getDeclaredFields();
		FactoryColumn factory = new FactoryColumn();
		for(Field field : fs) {
			column = factory.createColumn(this, field);
			list.add(column);
		}
		return list;
	}

	@Override
	public Iterator<IPoint> iterator() {
		return listePoints.iterator();
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getNbLines() {
		return listePoints.size();
	}

	@Override
	public void setLines(List<IPoint> lines) {
		listePoints=lines;
	}

	@Override
	public void addLine(IPoint element) {
		listePoints.add(element);
	}

	@Override
	public void addAllLine(List<IPoint> element) {
		listePoints.addAll(element);
	}

	@Override
	public List<Column> getListColumns() {
		return listeColumns;
	}

	@Override
	public List<IPoint> getListPoints() {
		return listePoints;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("DataSet [title=" + title);
		for(IPoint ipoint : listePoints) {
			sb.append(ipoint + "\n");
		}
		sb.append("ListeColumns=" + listeColumns);
		return sb.toString();
	}

	public List<Object> valueByColumn(Column col) {
		List<Object> list = new ArrayList<Object>();
		for(IPoint point : listePoints) {
			list.add(point.getValue(col));
		}
		return list;
	}

	public List<Column> getNormalizableColumns() {
		List<Column> res = new ArrayList<>();
		for (Column Column : listeColumns) {
			if(Column.isNormalizable())
				res.add(Column);
		}
		return res;
	}
}
