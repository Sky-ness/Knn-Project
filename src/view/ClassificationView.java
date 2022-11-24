package view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import model.Knn;
import model.Parser;
import model.Randomizer;
import utils.AbstractClassifier;
import utils.AbstractSubject;
import utils.IPoint;

public class ClassificationView extends AbstractView{
	@FXML
	private Button buttonSelectPoint;
	@FXML
	private ComboBox<String> classMethod;
	@FXML
	private Button valider;
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
			
			loadView();
			
			eventDetachWindow(p);
			afficher(vb);
			
		}catch(Exception e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}
	}
	/*
	 * retourne la liste des voisins les plus proches
	 */

	public void loadView() {
		items = classMethod.getItems();
		classMethod.setValue("KNN");
		items.add("KNN");
		items.add("Randomizer");
		
		items = distance.getItems();
		distance.setValue("Manhattan");
		items.add("Manhattan");
		items.add("Euclidienne");
		
		buttonSelectPoint.setOnAction(e-> new PointView(parser));
		labelSelectPoint.setOnMouseClicked(e-> labelSelectPoint.setText(PointView.selectedPoint.toString()));
		valider.setOnAction(e-> {
			//TODO Graphique a update quand on appuie sur la classification 
			 
			AbstractClassifier a = ChooseClassifier(classMethod.getValue());
			List<IPoint> voisin = ChooseDistance(a, distance.getValue(),(int) neighborSlider.getValue());
					
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
