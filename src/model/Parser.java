package model;

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

public class Parser implements IMVCModel{
	protected String title;
	protected DataSet datas;
	
	public Parser(String title){
		this.title=title;
	}
	
	@Override
	public void loadFromFile(String datafile) {
		String lowercase = datafile.toLowerCase();
		try {
			if(lowercase.contains("pokemon")) { 
				datas = readFile(datafile, Pokemon.class);
			} else if(lowercase.contains("titanic")) { 
				datas = readFile(datafile, Titanic.class);
			} else if(lowercase.contains("iris")) { 
				datas = readFile(datafile, Iris.class);
			}
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getTitle() {
		return title;
	}

	public DataSet getDatas() {
		return datas;
	}
	
	@Override
	public int getNbLines() {
		// TODO Auto-generated method stub
		return datas.getNbLines();
	}

	@Override
	public void setLines(List<IPoint> lines) {
		this.datas.setLines(lines);
		
	}

	@Override
	public void addLine(IPoint element) {
		this.datas.listePoints.add(element);
		
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
	public void loadFromString(String data) {
		
	}

	@Override
	public Column defaultXCol() {
		return datas.listeColumns.get(0);
	}

	@Override
	public Column defaultYCol() {
		return datas.listeColumns.get(0);
	}

	@Override
	public int nbColumns() {
		return datas.listeColumns.size();
	}

	@Override
	public List<IColumn> getNormalizableColumns() {
		return datas.getNormalizableColumns();
	}
	
	@SuppressWarnings("unchecked")
	public static DataSet readFile(String link,@SuppressWarnings("rawtypes") Class cl) throws IllegalStateException, IOException {
		List<IPoint> points = new ArrayList<IPoint>();
		points = new CsvToBeanBuilder<IPoint>(Files.newBufferedReader(Paths.get(link)))
				.withSeparator(',')
				.withType(cl)
				.build().parse();
		/*
		 * remplacer le "test" par le nom du fichier dans le lien
		 */
		return new DataSet("test",points);
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
