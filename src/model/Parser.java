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
	protected List<IPoint> lines;
	protected String title;
	protected DataSet datas;
	

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
	
	public Parser(String title, List<IPoint> listePoints){
		this.title=title;
		this.lines=listePoints;
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getNbLines() {
		// TODO Auto-generated method stub
		return lines.size();
	}

	@Override
	public void setLines(List<IPoint> lines) {
		this.lines=lines;
		
	}

	@Override
	public void addLine(IPoint element) {
		this.lines.add(element);
		
	}

	@Override
	public void addAllLine(List<IPoint> element) {
		this.lines.addAll(element);
		
	}

	@Override
	public Iterator<IPoint> iterator() {
		return lines.iterator();
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
	public void loadFromString(String data) {
		// TODO Auto-generated method stub
		
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
	public void addCategory(ICategory classe) {
		// TODO
	}

	@Override
	public Collection<ICategory> allCategories() {
		return null;
	}

	@Override
	public int nbColumns() {
		return datas.listeColumns.size();
	}

	@Override
	public List<IColumn> getNormalizableColumns() {
		return datas.getNormalizableColumns();
	}
	
	public static void main(String[] args) throws IllegalStateException, IOException {
		DataSet test = Parser.readFile("data/pokemon_train.csv", Pokemon.class);
		System.out.println(test.listeColumns);
	}
}
