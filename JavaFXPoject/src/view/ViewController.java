package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewController implements Initializable{
	@FXML ImageView imageView;
	@FXML TableView<Phone> tableView;
	@FXML ListView<String> listView;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//초기화지정
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("GalaxyS1");
		list.add("GalaxyS2");
		list.add("GalaxyS3");
		list.add("GalaxyS4");
		list.add("GalaxyS5");
		list.add("GalaxyS6");
		list.add("GalaxyS7");
		listView.setItems(list);
		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				tableView.getSelectionModel().select(arg2.intValue());
				tableView.scrollTo(arg2.intValue()); // 스크롤을 선택위치로 이동
			}});;
		
		
		tableView.setItems(FXCollections.observableArrayList(
				new Phone("GalaxyS1","Phone01.png"),
				new Phone("GalaxyS2","Phone02.png"),
				new Phone("GalaxyS3","Phone03.png"),
				new Phone("GalaxyS4","Phone04.png"),
				new Phone("GalaxyS5","Phone05.png"),
				new Phone("GalaxyS6","Phone06.png"),
				new Phone("GalaxyS7","Phone07.png")
				));
		TableColumn<Phone,?> tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
		TableColumn<Phone,?> tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(new PropertyValueFactory("image"));
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {

			@Override
			public void changed(ObservableValue<? extends Phone> arg0, Phone arg1, Phone arg2) {
				
				imageView.setImage(new Image("/images/"+arg2.getImage()));
			}});
	}
	public void handleBtnOkAction() {
		
	}
	public void handleBtnCancelAction() {
		
	}
}
