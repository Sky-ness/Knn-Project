package model.abstracts;

import java.util.Iterator;
import java.util.List;

import util.IDataset;
import util.IPoint;

public abstract class DataSet implements IDataset {
	private String title;
	private List<IPoint> lines;
	
	public DataSet(String title, List<IPoint> lines) {
		this.title = title;
		this.lines = lines;
	}

	@Override
	public Iterator<IPoint> iterator() {
		return lines.iterator();
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getNbLines() {
		return lines.size();
	}

	@Override
	public void setLines(List<IPoint> lines) {
		this.lines=lines;
		
	}

	@Override
	public void addLine(IPoint element) {
		lines.add(element);
		
	}

	@Override
	public void addAllLine(List<IPoint> element) {
		lines.addAll(element);
		
	}

}
