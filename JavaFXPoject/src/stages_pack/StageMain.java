package stages_pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageMain extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("으아ㅏㅏ나라아낭나ㅏ아");
		arg0.show();
//		FXMLLoader loader = new FXMLLoader();
//		// 컨트롤러에 스테이지값을 넘겨줌 fxml에 지정되어있는 컨트롤러.java가져옴 
//		StageController cont = loader.getController();
//		cont.setPrimatyStage(arg0);
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}	
