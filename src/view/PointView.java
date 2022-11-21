package view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.Parser;
import utils.IPoint;
import utils.Observer;
import utils.Subject;

public class PointView extends AbstractView implements Observer{

	protected static IPoint selectedPoint ;
	
	public PointView(Parser p){
		
		datas=p.getDatas();
		datas.attach(this);
		VBox vb= loadView(p);
		Stage stage = initStage();
		Scene scene = initScene(vb);
		stage.setScene(scene);
		stage.show();
	}

	public List<TableColumn<IPoint,?>> columnFactory() {
		List<TableColumn<IPoint,?>> listColumn = new ArrayList<>();
		
		for(Column c: datas.getListeColumns()) {
			TableColumn column = new TableColumn(c.getName());
			column.setMinWidth(100);
			column.setCellValueFactory(new PropertyValueFactory<IPoint,Double>(c.getName()));
			listColumn.add(column);
		}
		
		return listColumn;
	}
	public VBox loadView(Parser p) {
		VBox vb = new VBox(); 
		final ObservableList<IPoint> data = FXCollections.observableArrayList(datas.getListePoints());
		
		Button b = new Button("selectionner un point");
		TableView<IPoint> table = new TableView<IPoint>();
		table.setEditable(true);

		List<TableColumn<IPoint,?>> listColumn = columnFactory();

		table.setItems(data);
		table.getColumns().addAll(listColumn);
		
		b.setOnAction(e->{
			selectedPoint = table.getSelectionModel().getSelectedItem();
		});
		vb.getChildren().addAll(table,b);
		vb.setAlignment(Pos.CENTER);
		return vb;
	}
	@Override
	public void update(Subject subj) {
		loadView(GraphView.p);
	}
}
