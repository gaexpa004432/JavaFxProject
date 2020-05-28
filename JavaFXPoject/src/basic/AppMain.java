package basic;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class AppMain extends Application{

	public AppMain(){
		System.out.println(Thread.currentThread().getName()+": app() 실행중");
	}
	
	
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName()+"init");
	}
	



	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName()+"stop");
	}



	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(Thread.currentThread().getName()+"start");
		VBox root = new VBox(); //컨트롤 설정 생성
		root.setPrefWidth(650);
		root.setPrefHeight(350);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		
		Label label = new Label();
		label.setText("hello javaFX");
		label.setFont(new Font(50));
		Button button = new Button();
		button.setText("OK");
		button.setOnAction(new EventHandler<ActionEvent>(){ //버튼 액션
			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
			}});
		
		root.getChildren().add(label); // 컨트롤설정에 붙이기
		root.getChildren().add(button); //
		
		Scene scene = new Scene(root); // 컨트롤설정을 신에 올림
		arg0.setScene(scene);
		arg0.show();
	}

public static void main(String[] args) {
	launch(args);
}
}
