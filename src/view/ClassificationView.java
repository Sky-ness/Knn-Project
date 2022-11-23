package view;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Distance;
import model.Knn;
import model.Parser;
import model.Randomizer;
import utils.AbstractSubject;
import utils.IPoint;

public class ClassificationView extends AbstractView{
	@FXML
	private Button buttonSelectPoint;
	@FXML
	private ComboBox<String> classMethod;
	@FXML
	private Button classifier;
	@FXML
	private ComboBox<String> distance;
	@FXML
	private Slider neighborSlider;
	@FXML
	private Label labelSelectPoint;
    @FXML
    private Label testVoisin1;
    @FXML
    private Label testVoisin2;
    @FXML
    private Label testVoisin3;
    
    protected ObservableList<String> items;

	public ClassificationView(Parser p) {
		super(p);
		
		try {
			vb = initFxml("fxmlModel/classification.fxml");
			Scene scene = initScene(vb);
			loadView();
			stage.setScene(scene);
		}catch(Exception e) {e.printStackTrace();}
		stage.show();
	}
	/*
	 * retourne la liste des voisins les plus proches
	 */
	@SuppressWarnings("PMD.ExcessiveParameterList")
	private List<IPoint> modelClassification(String classification, IPoint point, Distance distance,int voisin) {
		if (classification.equals("KNN")) {
			Knn k = new Knn();
			return k.neighbor(voisin, point, distance, parser.getListPoints(), parser.getListColumns());
		}
		if (classification.equals("Randomizer")) {
			Randomizer r = new Randomizer();
			return r.neighbor(voisin, point, distance, parser.getListPoints(), parser.getListColumns());
		}
		return null;
	}

	public void loadView() {
		items = classMethod.getItems();
		classMethod.setValue("KNN");
		items.add("KNN");
		items.add("Randomizer");
		
		buttonSelectPoint.setOnAction(e-> new PointView(parser));
		labelSelectPoint.setOnMouseClicked(e-> labelSelectPoint.setText(PointView.selectedPoint.toString()));
		classifier.setOnAction(e-> {
			/*
			 *TODO Graphique a update quand on appuie sur la classification 
			 */
			List<IPoint> voisin = modelClassification(classMethod.getValue(),PointView.selectedPoint,new Distance(),(int) neighborSlider.getValue());
			testVoisin1.setText(voisin.get(1).toString());
			testVoisin2.setText(voisin.get(2).toString());
			testVoisin3.setText(voisin.get(3).toString());
		
		});
	}
	@Override
	public void update(AbstractSubject subj) {
		loadView();
		System.out.println("ajout d'un point dans la classification");
	}
}
