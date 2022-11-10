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
import utils.IDataset;
import utils.IMVCModel;
import utils.IPoint;

public class Parser implements IMVCModel{
	protected List<IPoint> lines;
	protected String title;
	
	public static DataSet readFile(String link,Class cl) throws IllegalStateException, IOException {
		List<IPoint> list = new ArrayList<IPoint>();
		list = new CsvToBeanBuilder<IPoint>(Files.newBufferedReader(Paths.get(link)))
				.withSeparator(',')
				.withType(cl)
				.build().parse();
		return new DataSet("test",list);
			
		
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
		// TODO Auto-generated method stub
		
		// if les colonnes load = ceux de pokémon ---> Load le reste avec pokemon.class
		// if les colonnes load = ceux de iris ---> Load le reste avec iris.class
		// if les colonnes load = ceux de titanic ---> Load le reste avec titanic.class
		
	}

	@Override
	public void loadFromString(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IColumn defaultXCol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IColumn defaultYCol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCategory(ICategory classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<ICategory> allCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nbColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<IColumn> getNormalizableColumns() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) throws IllegalStateException, IOException {
		DataSet test = Parser.readFile("data/iris.csv", Iris.class);
		System.out.println(test.toString());
	}
}
