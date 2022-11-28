package view;


import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Category;
import model.Column;
import model.IPoint;
import model.Iris;
import model.Parser;
import model.Pokemon;
import model.Titanic;
import utils.AbstractSubject;

public class AddPointView extends AbstractView {
	
	private Category category;
	
	public AddPointView(Parser p) {
		super(p);

		vb = initVBox();
		load();

		eventDetachWindow(p);		
		afficher(vb);
	}

	@SuppressWarnings("PMD.LawOfDemeter")
	@Override
	public void load() {

		reset();

		ObservableList<Node> childs = vb.getChildren();

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
		
		if (category!=null) {
			parser.addAllLine(category.getListPoints());
			parser.allCategories().remove(category);
		}
		b.setOnAction((event) -> {
			String [] parameter = new String [listTf.size()];
			for(int i =0;i<listTf.size();i++) {
				parameter[i]=listTf.get(i).getText();
			}
			if(c.equals(Iris.class)) {
				category = new Category("ajout",new Iris(parameter));
				parser.addCategory(category);
			}
			if(c.equals(Pokemon.class)) {
				category = new Category("ajout",new Pokemon(parameter));
				parser.addCategory(category);
			}
			if(c.equals(Titanic.class)) {
				category = new Category("ajout",new Titanic(parameter));
				parser.addCategory(category);
			}
		});
		for(int i=0;i<listLbl.size();i++) {
			childs.addAll(listLbl.get(i),listTf.get(i));
		}
		childs.add(b);
	}
	@Override
	public void reset() {
		if (vb.getChildren() != null)
			vb.getChildren().clear();
	}
	public VBox initVBox() {
		VBox vbx = new VBox();
		vbx.setPadding(new Insets(40));
		vbx.setAlignment(Pos.CENTER);
		return vbx;
	}
	@Override
	public void update(AbstractSubject subj) {
		load();
		System.out.println("update point");
	}

}
