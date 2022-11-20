package view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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

		final ObservableList<IPoint> data = FXCollections.observableArrayList(p.getDatas().getListePoints());

		Stage stage = initStage();
		VBox vb = new VBox(); 
		Button b = new Button("selectionner un point");
		TableView<IPoint> table = new TableView<IPoint>();
		table.setEditable(true);

		List<TableColumn<IPoint,?>> listColumn = new ArrayList<>();
		for(Column c: p.getDatas().getListeColumns()) {
			TableColumn column = new TableColumn(c.getName());
			column.setMinWidth(100);
			column.setCellValueFactory(new PropertyValueFactory<IPoint,Double>(c.getName()));
			listColumn.add(column);
		}
		table.setItems(data);
		table.getColumns().addAll(listColumn);
		
		b.setOnAction(e->{
			/*
			 *TODO update le point sélectionné avec un update 
			 */
			selectedPoint = table.getSelectionModel().getSelectedItem();
		});
		vb.getChildren().addAll(table,b);
		vb.setAlignment(Pos.CENTER);
		Scene scene = initScene(vb);
		stage.setScene(scene);
		stage.show();
	}
	public void update() {
		
	}
	@Override
	public void update(Subject subj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Subject subj, Object data) {
		// TODO Auto-generated method stub
		
	}

}
