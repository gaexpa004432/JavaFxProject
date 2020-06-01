package panes.vbox_hbox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable {
	
	@FXML
	Button prv;
	@FXML
	Button nxt;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nxt.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
			}
			
		});
		prv.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				
			}});
		}
	}


