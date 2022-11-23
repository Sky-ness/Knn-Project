package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import utils.ICategory;
import utils.IColumn;
import utils.IMVCModel;
import utils.IPoint;
import utils.AbstractSubject;

public class Parser extends AbstractSubject implements IMVCModel {
	
	protected String title;
	protected DataSet datas;

	@Override
	public void loadFromFile(String datafile,Class<? extends IPoint> c) throws IllegalStateException, IOException {
		List<IPoint> points = new ArrayList<IPoint>();
		points = new CsvToBeanBuilder<IPoint>(Files.newBufferedReader(Paths.get(datafile)))
				.withSeparator(',')
				.withType(c)
				.build().parse();
		datas = new DataSet(title,points);
	}
	
	public void loadFromFile(File f,Class<? extends IPoint> c) throws IllegalStateException, IOException {
		loadFromFile(f.getAbsolutePath(),c);
	}
	
	@Override
	public void loadFromString(String data) {
		String lowercase = data.toLowerCase();
		try {
			if(lowercase.contains("pokemon")) { 
				loadFromFile(data, Pokemon.class);
				title = "Pokemon";
			} else if(lowercase.contains("titanic")) { 
				loadFromFile(data, Titanic.class);
				title = "Titanic";
			} else if(lowercase.contains("iris")) {
				loadFromFile(data, Iris.class);
				title = "Iris";
			}
			else {
				title = "Other";
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		notifyObservers();
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getNbLines() {
		return datas.getNbLines();
	}
	
	@Override
	public List<Column> getListColumns() {
		return datas.listeColumns;
	}

	@Override
	public List<IPoint> getListPoints() {
		return datas.listePoints;
	}

	@Override
	public void setLines(List<IPoint> lines) {
		this.datas.setLines(lines);
		notifyObservers();
	}

	@Override
	public void addLine(IPoint element) {
		this.datas.listePoints.add(element);
		notifyObservers();
	}

	@Override
	public void addAllLine(List<IPoint> element) {
		this.datas.listePoints.addAll(element);
		notifyObservers();
	}

	@Override
	public Iterator<IPoint> iterator() {
		return datas.iterator();
	}

	@Override
	public Column defaultXCol() {
		for(Column c : datas.listeColumns)
			if (c.isNormalizable())
				return c;
		return null;
	}

	@Override
	public Column defaultYCol() {
		for(Column c : datas.listeColumns)
			if (c.isNormalizable()&& c!=defaultXCol())
				return c;
		return null;
	}

	@Override
	@SuppressWarnings("PMD.LawOfDemeter")
	public int nbColumns() {
		return getListColumns().size();
	}

	@Override
	public List<IColumn> getNormalizableColumns() {
		return datas.getNormalizableColumns();
	}

	@Override
	public void addCategory(ICategory classe) {
		// TODO
	}

	@Override
	public Collection<ICategory> allCategories() {
		return null;
	}

}
