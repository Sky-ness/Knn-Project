package view;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.Iris;
import model.Parser;
import model.Pokemon;
import model.Titanic;
import utils.AbstractSubject;
import utils.IPoint;

public class AddPointView extends AbstractView {

	public AddPointView(Parser p) {
		super(p);
		
		vb = loadView();
		
		eventDetachWindow(p);		
		afficher(vb);
	}

	@SuppressWarnings("PMD.LawOfDemeter")
	public VBox loadView() {
		VBox vb = new VBox();
		ObservableList<Node> childs = vb.getChildren();
		vb.setPadding(new Insets(40));
		Button b = new Button("valider");
		List<Label> listLbl = new ArrayList<Label>();
		List<TextField> listTf = new ArrayList<TextField>();
		for(Column c: parser.getListColumns()) {
			Label label = new Label(c.getName());
			label.setPadding(new Insets(5));
			TextField tf =new TextField();
			listLbl.add(label);
			listTf.add(tf);
		}
		List<IPoint> points = parser.getListPoints();
		IPoint first = points.get(0);
		Class<? extends IPoint> c = first.getClass();
		b.setOnAction((event) -> {
			String [] parameter = new String [listTf.size()];
			for(int i =0;i<listTf.size();i++) {
				parameter[i]=listTf.get(i).getText();
			}
			if(c.equals(Iris.class)) {
				parser.addLine(new Iris(parameter));
			}
			if(c.equals(Pokemon.class)) {
				parser.addLine(new Pokemon(parameter));
			}
			if(c.equals(Titanic.class)) {
				parser.addLine(new Titanic(parameter));
			}
		});
		for(int i=0;i<listLbl.size();i++) {
			childs.addAll(listLbl.get(i),listTf.get(i));
		}
		childs.add(b);
		vb.setAlignment(Pos.CENTER);
		return vb;
	}
	@Override
	public void update(AbstractSubject subj) {
		loadView();
		System.out.println("ajout d'un point");
	}


}
