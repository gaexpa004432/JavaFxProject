package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonController implements Initializable{
	@FXML Button btnNew,btnOpen,btnSave;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("/panes/icons/new.png");
		btnNew.setGraphic(new ImageView(img));
		img = new Image("/panes/icons/open.png");
		btnOpen.setGraphic(new ImageView(img));
		img = new Image("/panes/icons/save.png");
		btnSave.setGraphic(new ImageView(img));
		btnNew.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("new clicked");
			}});
		btnOpen.setOnAction((event) -> System.out.println("Open clicked"));
	}
	public void btnSaveAction(ActionEvent event) {
		System.out.println("save clicked");
	}

}
