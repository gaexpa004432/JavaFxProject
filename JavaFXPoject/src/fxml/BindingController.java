package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class BindingController implements Initializable {
	@FXML TextArea textArea1 , textArea2;
	@FXML Label label;
	@FXML Slider slider;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				label.setFont(new Font(arg2.intValue()));
			}
			});
	//	textArea2.textProperty().bind(textArea1.textProperty());
	//	textArea2.textProperty().bindBidirectional(textArea1.textProperty());
		Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
	}
	

}
