package model;

import java.util.Iterator;
import java.util.List;

import utils.ICategory;

public class Category implements ICategory{

	protected String title;
	protected List<IPoint> listePoints;
	protected List<Column> listeColumns; 
	
	public Category(String title, List<IPoint> listePoints,List<Column> listeColumn) {
		super();
		this.title = title;
		this.listePoints = listePoints;
		this.listeColumns = listeColumn;
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
		return null;
	}

	@Override
	public List<IPoint> getListPoints() {
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
