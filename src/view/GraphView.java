package view;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Column;
import model.DataSet;
import model.Distance;
import model.Knn;
import model.Parser;
import model.Randomizer;
import utils.IPoint;

public class GraphView extends AbstractView{
	@FXML
	private ScatterChart<Double,Double> chart;
	@FXML
	private Button clear;
	@FXML
	private MenuItem pointView;
	@FXML
	private MenuItem addPoint;
	@FXML
	private Button classifier;
	@FXML
	private Button load;
	@FXML
	private MenuItem titanicLoadButton;
	@FXML
	private MenuItem pokemonLoadButton;
	@FXML
	private MenuItem irisLoadButton;
	@FXML
	private MenuItem explorateur;
	@FXML
	private ComboBox<String> absCol;
	@FXML
	private ComboBox<String> ordCol;
	@FXML
	private ComboBox<String> classMethod;
	@FXML
	private ProgressBar robustesseBar;
	@FXML
	private Slider neighborSlider;
	@FXML
	private Label robustesse;

	private DataSet datas;

	private final String pathPokemon="data/pokemon_train.csv";
	private final String pathIris="data/iris.csv";
	private final String pathTitanic="data/titanic.csv";

	public GraphView(){

		Stage stage = initStage();
		try {
			VBox fxml = initFxml();
			Scene scene = initScene(fxml);			
			Parser p = new Parser();
			start(p,pathPokemon);

			irisLoadButton.setOnAction(e-> {
				start(p,pathIris);
			});
			pokemonLoadButton.setOnAction(e-> {
				start(p,pathPokemon);
			});
			titanicLoadButton.setOnAction(e-> {
				start(p,pathTitanic);
			});
			explorateur.setOnAction(e-> {
				File f = new FileChooser().showOpenDialog(this);
				if (f!=null)
					start(p,f.getAbsolutePath());
			});

			addPoint.setOnAction(e-> new AddPointView(p));
			pointView.setOnAction(e-> new PointView(p));
			clear.setOnAction(e-> chart.getData().clear());

			stage.setScene(scene);

		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}

		stage.show();
	}
	private void start(Parser p, String path) {
		resetModel(p);
		p.loadFromFile(path);
		datas = p.getDatas();
		loadModel(p);
	}

	public void loadModel(Parser p) {

		// ajout des colonnes dans la comboBox

		absCol.setValue(p.defaultXCol().getName());
		for(Column c: datas.getListeColumns())
			absCol.getItems().add(c.getName());

		ordCol.setValue(p.defaultYCol().getName());
		for(Column c: datas.getListeColumns())
			ordCol.getItems().add(c.getName());

		classMethod.setValue("Randomizer");
		classMethod.getItems().add("Randomizer");
		classMethod.getItems().add("Knn");
		load.setOnAction(e -> pointGenerator(p));
		classifier.setOnAction(e-> {
			/*
			 * j'ai mis un point par default mais il faudra le selectionné
			 */
			IPoint defaultPoint = p.getDatas().getListePoints().get(0);
			/*
			 * Pareil pour la distance 
			 */
			Distance defaultDistance  = new Distance();
			/*
			 * choisir le nombre de voisin par default 0
			 */
			modelClassification(classMethod.getValue(),defaultPoint,defaultDistance);	
		});
	}
	private void resetModel(Parser p){
		absCol.getItems().clear();
		ordCol.getItems().clear();
		classMethod.getItems().clear();
		chart.getData().clear();
	}

	private void pointGenerator(Parser p){
		Column absSelected=searchColumnbyName(absCol.getValue());
		Column ordSelected=searchColumnbyName(ordCol.getValue());

		XYChart.Series series1 = new XYChart.Series();
		series1.setName(p.getTitle());

		for(IPoint i : datas.getListePoints()) {
			series1.getData().add(new XYChart.Data<Double, Double>(absSelected.getNormalizedValue(i),ordSelected.getNormalizedValue(i)));
		}
		chart.getData().clear();
		chart.getData().addAll(series1);
	}

	private Column searchColumnbyName(String name){
		for(Column c : datas.getListeColumns())
			if(name.equals(c.getName())) 
				return c;
		return null;
	}
	private List<IPoint> modelClassification(String classification, IPoint point, Distance distance) {
		if (classification.equals("Knn")) {
			Knn k = new Knn();
			return k.neighbor(3, point, distance, datas.getListePoints(), datas.getListeColumns());
		}
		if (classification.equals("Randomizer")) {
			Randomizer r = new Randomizer();
			return r.neighbor(0, point, distance, datas.getListePoints(), datas.getListeColumns());
		}
		return null;
	}

}
