package view;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Column;
import model.Parser;
import utils.IPoint;
import utils.Observer;
import utils.Subject;

public class GraphView extends AbstractView implements Observer{
	@FXML
	private ComboBox<String> absCol;
	@FXML
	private MenuItem addPoint;
	@FXML
	private ScatterChart<Double,Double> chart;
	@FXML
	private Button classification;
	@FXML
	private Button clear;
	@FXML
	private MenuItem explorateur;
	@FXML
	private MenuItem irisLoadButton;
	@FXML
	private Button load;
	@FXML
	private ComboBox<String> ordCol;
	@FXML
	private MenuItem pointView;
	@FXML
	private MenuItem pokemonLoadButton;
	@FXML
	private Label robustesse;
	@FXML
	private ProgressBar robustesseBar;
	@FXML
	private MenuItem titanicLoadButton;

	private final String pathPokemon="data/pokemon_train.csv";
	private final String pathIris="data/iris.csv";
	private final String pathTitanic="data/titanic.csv";
	
	public GraphView(){
		/*
		 *TODO update le dataSet des qu'on load un autre model au lieu d'utiliser un parser en paramètre 
		 */
		Parser p = new Parser();
		Stage stage = initStage();
		try {
			VBox fxml = initFxml("fxmlModel/graphique.fxml");
			Scene scene = initScene(fxml);
			
			start(p,pathPokemon);
			datas.attach(this);
			
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
			classification.setOnAction(e-> new ClassificationView(p));
			clear.setOnAction(e-> resetModel());
			stage.setScene(scene);

		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}
		stage.show();
	}
	private void start(Parser p, String path) {
		resetModel();
		p.loadFromFile(path);
		datas = p.getDatas();
		loadView(p);
	}
	public void loadView(Parser p) {

		absCol.setValue(p.defaultXCol().getName());
		for(Column c: datas.getListeColumns())
			if(c.isNormalizable())
				absCol.getItems().add(c.getName());

		ordCol.setValue(p.defaultYCol().getName());
		for(Column c: datas.getListeColumns())
			if(c.isNormalizable())
				ordCol.getItems().add(c.getName());

		load.setOnAction(e -> pointGenerator());
		robustesseBar.setProgress(0.50);
	}

	private void resetModel(){
		absCol.getItems().clear();
		ordCol.getItems().clear();
		chart.getData().clear();
	}

	private void pointGenerator(){
		Column absSelected=searchColumnbyName(absCol.getValue());
		Column ordSelected=searchColumnbyName(ordCol.getValue());

		XYChart.Series series1 = new XYChart.Series();
		series1.setName(datas.getTitle());

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
	@Override
	public void update(Subject subj) {
//		loadView(p);
		System.out.println("ajout d'un point dans le graph");
	}

}
