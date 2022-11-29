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

import utils.AbstractClassifier;
import utils.AbstractSubject;
import utils.IMVCModel;

public class Parser extends AbstractSubject implements IMVCModel {
	
	protected String title;
	protected DataSet datas;
	protected Collection<Category> categories;

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
		String lowercase;
		try {
			lowercase = data.length()>0 ? data.toLowerCase() : "";
			if(lowercase.contains("pokemon")) { 
				loadFromFile(data, Pokemon.class);
				categories = creerCategory(defaultColCategory());
				title = "Pokemon";
			} else if(lowercase.contains("titanic")) { 
				loadFromFile(data, Titanic.class);
				categories = creerCategory(defaultColCategory());
				title = "Titanic";
			} else if(lowercase.contains("iris")) {
				loadFromFile(data, Iris.class);
				categories = creerCategory(defaultColCategory());
				title = "Iris";
			}
			else {
				title = "Other";
				datas = new DataSet(title,new ArrayList<IPoint>());
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
	

	public Column defaultColCategory() {
		// partant de la fin pour mieux voir genre col pokemon sera legendaire, iris sera variety
		for(int i=this.getListColumns().size()-1;i>0;i--) {
			if(this.getListColumns().get(i).isNormalizable()) {
				return this.getListColumns().get(i);
			}
		}
		return null;
	}

	@Override
	@SuppressWarnings("PMD.LawOfDemeter")
	public int nbColumns() {
		return getListColumns().size();
	}

	@Override
	public List<Column> getNormalizableColumns() {
		return datas.getNormalizableColumns();
	}

	@Override
	public void addCategory(Category classe) {
		categories.add(classe);
		notifyObservers();
	}
	public void removeCategory(Category classe) {
		categories.remove(classe);
	}

	@Override
	public Collection<Category> allCategories() {
		return categories;
	}
	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}
	public Collection<Category> creerCategory(Column col) {
		Collection<Category> categories = new ArrayList<>();
		List<IPoint> points = this.getListPoints();
		List<Object> disctintValue = new ArrayList<>();
		Object value;
		for(IPoint point:points) {
			value = point.getValue(col);
			if(value == null) {
				value = new NullObject();
			}
			if(!disctintValue.contains(value)){
				disctintValue.add(value);
			}
			
		}
		List<IPoint> lp = new ArrayList<IPoint>();
		for(IPoint point : points) {
			lp.add(point);
		}
		

		for(Object object: disctintValue) {
			Category c = new Category(col.getName()+" "+object.toString(), new ArrayList<IPoint>(),this.getListColumns());
		
			for(IPoint point:lp) {
				if(object.equals(point.getValue(col))){
					c.addLine(point);
					
				}
			}
			categories.add(c);
		}
		
		return categories;
		
	}

}
