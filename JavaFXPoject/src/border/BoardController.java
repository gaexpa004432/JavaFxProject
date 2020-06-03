package border;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import view.Phone;

public class BoardController implements Initializable{
	@FXML TextField textField1;
	@FXML ComboBox<String> comboBox;
	@FXML TextField textField2;
	@FXML TextArea textArea;
	@FXML TableView<Board> tableView;
	List<Board> list = new ArrayList<>();
Connection conn;
PreparedStatement pstmt;
	public void Ex(){
	
	
	
	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		String sql = "select * from board1";
		int i =0;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board emp = new Board(rs.getString("title"),rs.getString("publicity"),rs.getString("exit_date"),rs.getString("content"));
			
//				emp.setTitle(rs.getString("title"));
//				emp.setContent(rs.getString("content"));
//				emp.setPassword(rs.getString("password"));
//				emp.setPublicity(rs.getString("publicity"));
//				emp.setExitDate(rs.getString("exit_date"));
				//ObservableList<String> list1 = FXCollections.observableArrayList();
				//list1.add(list.get(i++).getTitle());
//				System.out.println(list.get(0).getTitle());
				//list1.add();
				tableView.setItems(FXCollections.observableArrayList(new Board(emp.getTitle())));
				TableColumn<Board,?> tcSmartPhone = tableView.getColumns().get(0);
				tcSmartPhone.setCellValueFactory(new PropertyValueFactory("title"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
