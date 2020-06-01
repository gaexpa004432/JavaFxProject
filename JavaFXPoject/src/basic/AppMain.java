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
import javafx.stage.WindowEvent;

public class AppMain extends Application {

	public AppMain() {
		System.out.println(Thread.currentThread().getName() + ": app() 실행중");
	}

	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + "init");
	}

	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + "stop");
	}

	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(Thread.currentThread().getName() + "start");
		VBox root = new VBox(); // 컨트롤 설정 생성
		root.setPrefWidth(650);
		root.setPrefHeight(350);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);

		Label label = new Label();
		label.setText("hello javaFX");
		label.setFont(new Font(50));

		Button button = new Button();
		Button button1 = new Button();
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				label.setText("취소소소소소취소");
			}
		});
		button.setPrefSize(100, 100);
		button1.setPrefSize(100, 100);
		button.setText("OK");
		button1.setText("cancle");
		button.setOnAction(new EventHandler<ActionEvent>() { // 버튼 액션
			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
			}
		});

		root.getChildren().add(label); // 컨트롤설정에 붙이기
		root.getChildren().add(button); //
		root.getChildren().add(button1);

		Scene scene = new Scene(root); // 컨트롤설정을 신에 올림
		arg0.setScene(scene);
		arg0.show();
		arg0.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				System.out.println(event);
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
