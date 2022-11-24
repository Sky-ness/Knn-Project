package view;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import model.Column;
import model.Parser;
import model.Robustesse;
import utils.AbstractClassifier;
import utils.AbstractSubject;

public class RobustesseView extends AbstractView{
    @FXML
    private ComboBox<String> colonne;
    @FXML
    private ComboBox<String> distance;
    @FXML
    private ProgressBar robustesseBar;
    @FXML
    private Label robustesseIndicator;
    @FXML
    private Slider neighborSlider;
    @FXML
    private Button valider;

	public RobustesseView(Parser p) {
		super(p);
		
		try {
			vb = initFxml("fxmlModel/robustesse.fxml");

			afficherRobustesse(p);
			valider.setOnAction(e-> afficherRobustesse(p));
			
			eventDetachWindow(p);
			afficher(vb);
			
		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}

	}
	public void afficherRobustesse(Parser p) {
		Robustesse r = new Robustesse();
		AbstractClassifier a = ChooseClassifier(distance.getValue());
		Column c = searchColumnbyName(colonne.getValue());
		
		robustesseBar.setProgress(r.calc(p,(int)neighborSlider.getValue(),a,c));
		robustesseIndicator.setText(""+r.calc(p,(int)neighborSlider.getValue(),a,c)+"%");
	}
	private void loadView() {
		ObservableList<String> items = distance.getItems();
		distance.setValue("Manhattan");
		items.add("Manhattan");
		items.add("Euclidienne");
		
		ObservableList<String> items2 = colonne.getItems();
		distance.setValue("Manhattan");
		items2.add("Manhattan");
		items2.add("Euclidienne");
	}
	@Override
	public void update(AbstractSubject subj) {
		// TODO Auto-generated method stub
		
	}
}
