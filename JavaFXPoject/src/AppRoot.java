import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppRoot extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		Parent hbox = FXMLLoader.load(getClass().getResource("Root.fxml"));
		
		Scene scene = new Scene(hbox);
		arg0.setTitle("real");
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}


}
