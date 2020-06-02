package input;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
	Button btnReg, btnCancle;
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
	

	public void handleBtnCancelAction() {
		Platform.exit();
	}

}
