package model;

import java.util.Iterator;
import java.util.List;

import utils.AbstractSubject;
import utils.ICategory;

public class Category extends AbstractSubject implements ICategory {

	protected String title;
	protected List<AbstractPoint> listePoints;
	protected List<Column> listeColumns; 
	
	public Category(String title, List<AbstractPoint> listePoints,List<Column> listeColumn) {
		super();
		this.title = title;
		this.listePoints = listePoints;
		this.listeColumns = listeColumn;
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
		notifyObservers();
	}

	@Override
	public void addLine(AbstractPoint element) {
		listePoints.add(element);
		notifyObservers();
	}

	@Override
	public void addAllLine(List<AbstractPoint> element) {
		listePoints.addAll(element);
		notifyObservers();
	}

	@Override
	public List<Column> getListColumns() {
		return null;
	}

	@Override
	public List<AbstractPoint> getListPoints() {
		return listePoints;
	}

	@Override
	public String toString() {
		return "Category [title=" + title + "]";
	}

	public List<Column> getListeColumns() {
		return listeColumns;
	}

	public void setListeColumns(List<Column> listeColumns) {
		this.listeColumns = listeColumns;
	}

	
	
}
