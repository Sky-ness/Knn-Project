package model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.IDataset;

public class DataSet implements IDataset{

	protected String title;
	protected List<AbstractPoint> listePoints;
	protected List<Column> listeColumns; 

	public DataSet(String title,List<AbstractPoint> listePoints) {
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
	public Iterator<AbstractPoint> iterator() {
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
	public void setLines(List<AbstractPoint> lines) {
		listePoints=lines;
	}

	@Override
	public void addLine(AbstractPoint element) {
		listePoints.add(element);
	}

	@Override
	public void addAllLine(List<AbstractPoint> element) {
		listePoints.addAll(element);
	}

	@Override
	public List<Column> getListColumns() {
		return listeColumns;
	}

	@Override
	public List<AbstractPoint> getListPoints() {
		return listePoints;
	}

	@Override
	public String toString() {
		StringBuilder stringbuilder = new StringBuilder("");
		stringbuilder.append("DataSet [title=" + title);
		for(AbstractPoint ipoint : listePoints) {
			stringbuilder.append(ipoint + "\n");
		}
		stringbuilder.append("ListeColumns=" + listeColumns);
		return stringbuilder.toString();
	}

	public List<Object> valueByColumn(Column column) {
		List<Object> list = new ArrayList<Object>();
		for(AbstractPoint point : listePoints) {
			list.add(point.getValue(column));
		}
		return list;
	}

	public List<Column> getNormalizableColumns() {
		List<Column> resultat = new ArrayList<>();
		for (Column column : listeColumns) {
			if(column.isNormalizable())
				resultat.add(column);
		}
		return resultat;
	}
}
