package input;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InputController implements Initializable {
	@FXML
	TextArea txtContent;
	@FXML
	TextField txtTitle;
	@FXML
	PasswordField txtPassword;
	@FXML
	ComboBox<String> comboPublic;
	@FXML
	Button btnReg, btnCancle ,chart;
	@FXML
	DatePicker dateExit;
	Connection conn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void handleBtnRegAction(ActionEvent a) {
		String title = txtTitle.getText();
		String Password = txtPassword.getText();
		String strPublic = comboPublic.getValue();
		LocalDate localDate = dateExit.getValue();
		String content = txtContent.getText();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		String sql = "insert into board1(title,content,password,publicity,exit_date) values(?,?,?,?,?)";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");//변환정보
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, txtTitle.getText());
			pstmt.setString(2, txtContent.getText());
			pstmt.setString(3, txtPassword.getText());
			pstmt.setString(4, comboPublic.getValue());
			pstmt.setString(5, dateExit.getValue().format(formatter)); //date 타입변환
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		txtTitle.setText(null);
		txtPassword.setText(null);
		comboPublic.setValue("공개");
		dateExit.setValue(null);
		txtContent.setText(null);
		
		}
	public void messageDialog(String message) { //새창으로 팝업
		Stage customStage = new Stage(StageStyle.UTILITY);
		customStage.initModality(Modality.WINDOW_MODAL);
		customStage.initOwner(txtPassword.getScene().getWindow());
		customStage.setTitle("확인");
		
		
		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(400, 150);
		
		ImageView imageView = new ImageView();
		imageView.setImage(new Image("/icons/dialog-info.png"));
		imageView.setFitHeight(50);
		imageView.setPreserveRatio(true);
		imageView.setLayoutX(15);
		imageView.setLayoutY(15);
		Button button = new Button ("확인");
		button.setLayoutX(336);
		button.setLayoutY(104);
		button.setOnAction(e -> customStage.close());
		Label label = new Label(message);
		label.setLayoutX(87);
		label.setLayoutY(33);
		label.setPrefHeight(15);
		label.setPrefWidth(290);
		ap.getChildren().add(imageView);
		ap.getChildren().add(button);
		ap.getChildren().add(label);
		
		Scene scene = new Scene(ap);
		customStage.setScene(scene);
		customStage.show();
	}
	
	public void messagePopup(String message) { //팝업띄우기
		
		HBox hbox = new HBox();
		hbox.setStyle("-fx-background-color: black;");
		hbox.setAlignment(Pos.CENTER);
		ImageView imageview = new ImageView();
		imageview.setImage(new Image("/icons/dialog-info.png"));
		imageview.setFitHeight(30);
		imageview.setFitWidth(30);
		Label label = new Label();
		hbox.setMargin(label, new Insets(0,5,0,5));
		label.setStyle("-fx-text-fill: white;");
		label.setText(message);
		
		hbox.getChildren().add(imageview);
		hbox.getChildren().add(label);
		
		Popup popup = new Popup();
		popup.getContent().add(hbox);
		popup.setAutoHide(true); // 다른곳 누르면 사라짐
		
		popup.show(txtPassword.getScene().getWindow()); //버튼에속해있는 윈도우에 팝업 띄우기 변수는 뭘하든 상관없음
		
		
	}

	public void handleBtnCancelAction() {
		//Platform.exit();
		messageDialog("다시입력하세요");
	}

}
