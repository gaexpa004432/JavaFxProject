package Button_EX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonController implements Initializable {
	@FXML
	Button btnExit;
	@FXML
	CheckBox chk1, chk2;
	@FXML
	RadioButton rad1, rad2, rad3;
	@FXML
	ImageView checkImageView, radioImageView;
	@FXML
	ToggleGroup group;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				System.out.println(arg2.getUserData().toString());
				radioImageView.setImage(new Image("/images/"+arg2.getUserData()+".png"));
			}
			
		});
		btnExit.setOnAction((event)-> Platform.exit());
	}

	public void handleChkAction() {
	//String imageName = "";
		
		if (chk1.isSelected() && (chk2.isSelected())) {
			//imageName = "@../images/geek-glasses-hair.gif";
			 checkImageView.setImage(new Image("/images/geek-glasses-hair.gif"));
			
		} else if (chk1.isSelected()) {
			//imageName = "@../images/geek-hair.gif";
			 checkImageView.setImage(new Image("/images/geek-glasses.gif"));
			 
		} else if (chk2.isSelected()) {
			//imageName = "@../images/geek-glasses.gif";
			 checkImageView.setImage(new Image("/images/geek-hair.gif"));
			 
		} else {
			//imageName = "@../images/geek.gif";
			checkImageView.setImage(new Image("/images/geek.gif" ));
		}
	}
	

	public void handleBtnExitAction() {
		
	}
}
