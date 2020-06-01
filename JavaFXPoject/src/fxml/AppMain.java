package fxml;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class AppMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		HBox hbox = new HBox();
//		Button button = new Button();
//		button.setText("OK");
//		hbox.getChildren().add(button);
		
		Scene scene = new Scene(hbox);
		
		
		
		arg0.setScene(scene);
		arg0.show();
		
		
		
	}

}
