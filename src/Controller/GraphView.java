package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import model.Category;
import model.Column;
import model.IPoint;
import model.Parser;
import utils.AbstractSubject;
import view.AbstractView;
import view.AddPointView;
import view.ClassificationView;
import view.PointView;
import view.RobustesseView;

@SuppressWarnings("PMD.TooManyFields")
public class GraphView extends AbstractView {
	@FXML
	private MenuItem explorateur;
	@FXML
	private MenuItem irisLoadButton;
	@FXML
	private MenuItem pokemonLoadButton;
	@FXML
	private MenuItem titanicLoadButton;
	@FXML
	private MenuItem addPoint;
	@FXML
	private MenuItem pointView;
	@FXML
	private ComboBox<String> absCol;
	@FXML
	private ComboBox<String> ordCol;
	@FXML
	private ComboBox<String> category;
	@FXML
	private ScatterChart<Double,Double> chart;
	@FXML
	private Button clear;
	@FXML
	private Button load;
	@FXML
	private Button classification;
	@FXML
	private Button robustesse;
	@FXML
	private Label easterEgg;
	@FXML
	private Label pointSelect;

	private static final String PATHPOKEMON="data/pokemon_train.csv";
	private static final String PATHIRIS="data/iris.csv";
	private static final String PATHTITANIC="data/titanic.csv";

	private Column defaultXCol;
	private Column defaultYCol;
	private Column defaultCategory;
	
	private String oldCategorySelected;

	private ObservableList<String> absColItems;
	private ObservableList<String> ordColItems;	
	private ObservableList<String> categoryItems;	
	private ObservableList<Series<Double,Double>> chartData;

	public GraphView(Parser p){
		super(p);

		try {
			vb = initFxml("fxmlModel/graphique.fxml");

			start(PATHPOKEMON);
			irisLoadButton.setOnAction(e-> {
				start(PATHIRIS);
			});
			pokemonLoadButton.setOnAction(e-> {
				start(PATHPOKEMON);
			});
			titanicLoadButton.setOnAction(e-> {
				start(PATHTITANIC);
			});
			explorateur.setOnAction(e-> {
				File f = new FileChooser().showOpenDialog(this);
				if (f!=null)
					start(f.getAbsolutePath());
			});

			addPoint.setOnAction(e-> new AddPointView(parser));
			pointView.setOnAction(e-> new PointView(parser));
			classification.setOnAction(e-> new ClassificationView(parser));
			robustesse.setOnAction(e-> new RobustesseView(parser));
			clear.setOnAction(e-> chart.getData().clear());
			easterEgg.setOnMouseClicked(e-> easterEgg.setText("merci de nous avoir écouter"));

			eventDetachWindow(p);			
			afficher(vb);

		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}
	}

	private void start(String path) {
		parser.loadFromString(path);
		load();
	}

	@Override
	public void load() {
		reset();

		defaultXCol = parser.defaultXCol();
		defaultYCol = parser.defaultYCol();
		defaultCategory = parser.defaultColCategory();

		absColItems = absCol.getItems();
		ordColItems = ordCol.getItems();
		categoryItems = category.getItems();

		absCol.setValue(defaultXCol.getName());
		for(Column c: parser.getListColumns())
			if(c.isNormalizable())
				absColItems.add(c.getName());

		ordCol.setValue(defaultYCol.getName());
		for(Column c: parser.getListColumns())
			if(c.isNormalizable())
				ordColItems.add(c.getName());

		category.setValue(defaultCategory.getName());
		for(Column c: parser.getListColumns())
			if(c.isNormalizable())
				categoryItems.add(c.getName());

		pointGenerator();
		load.setOnAction(e -> pointGenerator());
	}
	@Override
	public void reset(){

		if(absColItems != null)
			absColItems.clear();
		if(ordColItems != null)
			ordColItems.clear();
		if(categoryItems != null)
			categoryItems.clear();
		if(chartData != null)
			chartData.clear();
	}

	private void pointGenerator(){
		chartData = chart.getData();

		if(chartData != null)
			chartData.clear();

		//stockage de la colonne selectionné
		Column absSelected=searchColumnbyName(absCol.getValue());
		Column ordSelected=searchColumnbyName(ordCol.getValue());
		Column categorySelected = searchColumnbyName(category.getValue());

		/* 
		 * a faire que si la categories est différentes de l'ancienne
		 */
		if(oldCategorySelected==null || oldCategorySelected!=category.getValue()) {
			oldCategorySelected = category.getValue();
			Collection<Category> categories = parser.creerCategory(categorySelected);
			parser.setCategories(categories);
		}
		XYChart.Series<Double, Double> series2 = new XYChart.Series<Double, Double>();
		//création de la serie principale
		for(Category c: parser.allCategories()) {
			XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
			series.setName(c.getTitle());
			chartData.add(series);
			int cpt=0;
			for (IPoint i : c.getListPoints()) {

				series.getData().add(new XYChart.Data<Double, Double>(absSelected.getNormalizedValue(i),ordSelected.getNormalizedValue(i)));
				Data<Double, Double> data = series.getData().get(cpt);
				Node point = series.getData().get(cpt).getNode();

				//mise en place d'une fenetre au survole de la souris
				Tooltip tool = new Tooltip(absSelected.getName() + "=" + absSelected.getDenormalizedValue(data.getXValue()).toString() + "    "
						+ ordSelected.getName() +"=" + ordSelected.getDenormalizedValue(data.getYValue()).toString());
				Tooltip.install(point, tool);

				tool.setShowDelay(Duration.millis(10));

				//changement de couleur du point et affichage du point au survol de la souris
				String color = point.getStyle();
				point.setScaleX(1.25);
				point.setScaleY(1.25);

				point.setOnMouseEntered(e->{
					pointSelect.setText(i.toString()); 
					point.setStyle("-fx-background-color: black");
				});
				point.setOnMouseExited(e->{
					pointSelect.setText("point sélectionné"); 
					point.setStyle(color);
				});
				cpt++;
			}	
			
		}
		chartData.add(series2);
	}
	@Override
	public void update(AbstractSubject subj) {
		load();
	}

}
