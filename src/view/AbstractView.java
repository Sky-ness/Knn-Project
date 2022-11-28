package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.IPoint;
import model.Knn;
import model.Parser;
import model.Randomizer;
import utils.AbstractClassifier;
import utils.Observer;

public abstract class AbstractView extends Stage implements Observer{

	protected Parser parser;
	protected Stage stage;
	protected VBox vb;
	
	protected ObservableList<String> items;

	public AbstractView(Parser p) {
		this.parser=p;
		parser.attach(this);
		stage = initStage();
	}

	public abstract void load();
	public abstract void reset();
	
	public Stage initStage() {
		stage = new Stage();
		stage.setTitle("Graphique");
		return stage;
	}
	public Scene initScene(VBox vbox) {
		Scene scene = new Scene(vbox);
		return scene;
	}
	public VBox initFxml(String path)throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setController(this);
		FileInputStream fxmlStream = new FileInputStream(path);
		return (VBox) loader.load(fxmlStream);
	}
	public void afficher(VBox vb) {
		Scene scene = initScene(vb);
		stage.setScene(scene);
		stage.show();
	}
	public void eventDetachWindow(Parser p) {
		stage.addEventFilter(javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST, e -> p.detach(this));
	}
	
	public Column searchColumnbyName(String name){
		if(name == null)
			name = "";
		for(Column c : parser.getListColumns())
			if(name.equals(c.getName())) 
				return c;
		return null;
	}
	
	public AbstractClassifier ChooseClassifier(String classification) {
		if (classification.equals("Knn")) {
			Knn k = new Knn();
			return k;
		}
		if (classification.equals("Randomizer")) {
			Randomizer r = new Randomizer();
			return r;
		}
		return null;
	}
	
	public List<IPoint> ChooseDistance(AbstractClassifier a,String distance,int nbVoisin) {
		List<IPoint> voisin= new ArrayList<IPoint>();
		
		if(distance.equals("Manhattan")) {
			voisin = a.neighborManhattan(nbVoisin,PointView.selectedPoint,parser.getListPoints(),parser.getListColumns() );
			
		}
		if(distance.equals("Euclidienne")) {
			voisin = a.neighborEuclidienne(nbVoisin,PointView.selectedPoint,parser.getListPoints(),parser.getListColumns() );	
		}
		return voisin;
	}
	public void initComboBoxDistance(ComboBox<String> distance) {
		items = distance.getItems();
		distance.setValue("Manhattan");
		items.add("Manhattan");
		items.add("Euclidienne");
	}
	public void initComboBoxClassification(ComboBox<String> classification) {
		items = classification.getItems();
		classification.setValue("Knn");
		items.add("Knn");
		items.add("Randomizer");
	}
	
}
