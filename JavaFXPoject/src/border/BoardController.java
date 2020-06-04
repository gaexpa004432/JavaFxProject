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

import javax.security.auth.callback.Callback;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
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
//		String sql = "select * from board1";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				Board emp = new Board(rs.getString("title"),rs.getString("publicity"),rs.getString("exit_date"),rs.getString("content"));
			//ObservableArrayList<Board> boardList = FXCollections.observableArrayList();
			//boardList.add();
			//TableColumn<Board,String> tcTitle = new TableColumn<>();
			//tcTitle.setCellValueFactory(new Callback <CellDataFeatures<Board,String> ,ObservableValue<String>>(){
			//});
//			//tableView.getColumns().add(tcTitle);
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
				tableView.setItems(FXCollections.observableArrayList(getBoardList()));
				TableColumn<Board,?> tcTitle = tableView.getColumns().get(0);
				TableColumn<Board,?> tcDate = tableView.getColumns().get(1);
				tcTitle.setCellValueFactory(new PropertyValueFactory("title"));
				tcDate.setCellValueFactory(new PropertyValueFactory("exitDate"));
		tcTitle.setText("제목");
		tcDate.setText("날짜");
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Board>() {

			@Override
			public void changed(ObservableValue<? extends Board> arg0, Board arg1, Board arg2) {
				textField1.setText(arg2.getTitle());
				textField2.setText(arg2.getExitDate());
				textArea.setText(arg2.getContent());
				comboBox.setValue(arg2.getPublicity());
			}

			
			});
			}

	
	
	
	
	public ObservableList<Board> getBoardList(){
		ObservableList<Board> list = FXCollections.observableArrayList();
		String sql = "select * from board1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board(rs.getString("title"),rs.getString("publicity"),rs.getString("exit_date"),rs.getString("content"));
				list.add(board);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
