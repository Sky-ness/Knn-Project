package view;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import model.Parser;
import utils.AbstractClassifier;
import utils.AbstractSubject;
import utils.IPoint;

public class ClassificationView extends AbstractView{
	@FXML
	private Button buttonSelectPoint;
	@FXML
	private ComboBox<String> classification;
	@FXML
	private ComboBox<String> distance;
	@FXML
	private Button valider;
	@FXML
	private Slider neighborSlider;
	@FXML
	private Label labelSelectPoint;
    @FXML
    private Label testVoisin1;

	public ClassificationView(Parser p) {
		super(p);
		try {
			vb = initFxml("fxmlModel/classification.fxml");
			load();
			
			eventDetachWindow(p);
			afficher(vb);
			
		}catch(Exception e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}
	}
	@Override
	public void load() {
		reset();
		
		initComboBoxClassification(classification);
		initComboBoxDistance(distance);
		
		buttonSelectPoint.setOnAction(e-> new PointView(parser));
		labelSelectPoint.setOnMouseClicked(e-> labelSelectPoint.setText(PointView.selectedPoint.toString()));
		valider.setOnAction(e-> {
			//TODO Graphique a update quand on appuie sur la classification 
			AbstractClassifier a = ChooseClassifier(classification.getValue());
			List<IPoint> voisin = ChooseDistance(a, distance.getValue(),(int) neighborSlider.getValue());
					
			testVoisin1.setText(voisin.get(1).toString());
		});
	}
	@Override
	public void reset() {

	}
	@Override
	public void update(AbstractSubject subj) {
		load();
		System.out.println("update classification");
	}

}
