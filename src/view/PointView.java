package view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.Parser;
import utils.AbstractSubject;
import utils.IPoint;
import utils.Observer;

public class PointView extends AbstractView implements Observer{

	protected static IPoint selectedPoint ;
	private TableView<IPoint> table;
	private Button b;
	Stage stage = initStage();
	VBox vbx = new VBox();
	
	public PointView(Parser p){
		super(p);
	

		loadView();
		Scene scene = initScene(vbx);
		stage.setScene(scene);
		stage.show();
	}

	public List<TableColumn<IPoint,?>> columnFactory() {
		List<TableColumn<IPoint,?>> listColumn = new ArrayList<>();
		
		for(Column c: parser.getListColumns()) {
			TableColumn<IPoint,Double> column = new TableColumn<IPoint,Double>(c.getName());
			column.setMinWidth(100);
			column.setCellValueFactory(new PropertyValueFactory<IPoint,Double>(c.getName()));
			listColumn.add(column);
		}
		
		return listColumn;
	}
	public void loadView() {
		table = new TableView<IPoint>();
		table.setEditable(true);
		
		ObservableList<IPoint> data = FXCollections.observableArrayList(parser.getListPoints());		
	
		table.setItems(data);
		table.getColumns().addAll(columnFactory());	
		setButton(table);
		vbx.getChildren().addAll(table,b);
		vbx.setAlignment(Pos.CENTER);
		stage.show();
	}
	public void setButton(TableView<IPoint> table) {
		b = new Button("selectionner un point");
		b.setOnAction(e->{
			selectedPoint = table.getSelectionModel().getSelectedItem();
		});
	}
	
	@Override
	public void update(AbstractSubject subj) {
		loadView();
		System.out.println("ajout d'un point dans point View");
	}
}
