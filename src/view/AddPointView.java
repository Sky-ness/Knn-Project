package view;


import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.DataSet;
import model.Iris;
import model.Parser;
import model.Pokemon;
import model.Titanic;
import utils.Observer;
import utils.Subject;

public class AddPointView extends AbstractView implements Observer{

	public AddPointView(Parser p) {
		
		datas=p.getDatas();
		datas.attach(this);
		VBox vb = loadView(p);
		Stage stage = initStage();
		Scene scene = initScene(vb);
		stage.setScene(scene);
		stage.show();
	}

	public VBox loadView(Parser P) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(40));
		Button b = new Button("valider");
		List<Label> listLbl = new ArrayList<Label>();
		List<TextField> listTf = new ArrayList<TextField>();

		for(Column c: datas.getListeColumns()) {
			Label label = new Label(c.getName());
			label.setPadding(new Insets(5));
			TextField tf =new TextField();
			listLbl.add(label);
			listTf.add(tf);
		}
		@SuppressWarnings("rawtypes")
		Class c = datas.getListePoints().get(0).getClass();
		b.setOnAction((event) -> {
			String [] parameter = new String [listTf.size()];
			for(int i =0;i<listTf.size();i++) {
				parameter[i]=listTf.get(i).getText();
			}
			if(c.equals(Iris.class)) {
				datas.addLine(new Iris(parameter));
			}
			if(c.equals(Pokemon.class)) {
				datas.addLine(new Pokemon(parameter));
			}
			if(c.equals(Titanic.class)) {
				datas.addLine(new Titanic(parameter));
			}
		});
		for(int i=0;i<listLbl.size();i++) {
			vb.getChildren().addAll(listLbl.get(i),listTf.get(i));
		}
		vb.getChildren().add(b);
		vb.setAlignment(Pos.CENTER);
		return vb;
	}
	@Override
	public void update(Subject subj) {
//		loadView(GraphView.p);
		System.out.println("ajout d'un point");
	}

}
