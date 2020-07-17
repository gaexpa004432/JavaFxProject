package stages_pack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageController implements Initializable {
	@FXML
	TableView<Student> tableView;
	@FXML
	Button add, chart;
	ObservableList<Student> scores;
//	Stage primaryStage;
//	void setPrimatyStage(Stage primaryStage) {
//		this.primaryStage = primaryStage;
//	};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		add.setOnAction((e) -> buttonAddAction(e));
		chart.setOnAction((a) -> buttonChartAction(a));
		scores = FXCollections.observableArrayList();

		TableColumn<Student, ?> tcName = tableView.getColumns().get(0);
		tcName.setCellValueFactory(new PropertyValueFactory("name"));
		TableColumn<Student, ?> tcKorean = tableView.getColumns().get(1);
		tcKorean.setCellValueFactory(new PropertyValueFactory("korean"));
		TableColumn<Student, ?> tcMath = tableView.getColumns().get(2);
		tcMath.setCellValueFactory(new PropertyValueFactory("math"));
		TableColumn<Student, ?> tcEnglish = tableView.getColumns().get(3);
		tcEnglish.setCellValueFactory(new PropertyValueFactory("english"));
		tableView.setItems(scores);
	}

	public void buttonAddAction(ActionEvent a) {
		Stage addStage = new Stage(StageStyle.UTILITY);// 닫기버튼 타이틀만나옴
		addStage.initModality(Modality.WINDOW_MODAL);// 단기전까지 딴거못함
		addStage.initOwner(add.getScene().getWindow());
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddForm.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.setResizable(false); // 위도우 크기 변경불가
			addStage.show();

			Button btnFormAdd = (Button) parent.lookup("#btnFormAdd");
			btnFormAdd.setOnAction((e) -> {
				TextField txtName = (TextField) parent.lookup("#txtName");
				TextField txtkorean = (TextField) parent.lookup("#txtKorean");
				TextField txtmath = (TextField) parent.lookup("#txtMath");
				TextField txtenglish = (TextField) parent.lookup("#txtEnglish");
				Student student = new Student(txtName.getText(), Integer.parseInt(txtkorean.getText()),
						Integer.parseInt(txtmath.getText()), Integer.parseInt(txtenglish.getText()));
//				txtName.getText();
//				Integer.parseInt(txtkorean.getText()); 문자를 인트타입으로 형변환
//				txtmath.getText();
//				txtenglish.getText();
				scores.add(student);
				addStage.close();
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void buttonChartAction(ActionEvent e) {
		Stage chartStage = new Stage(StageStyle.UTILITY);// 닫기버튼 타이틀만나옴
		chartStage.initModality(Modality.WINDOW_MODAL);// 단기전까지 딴거못함
		chartStage.initOwner(add.getScene().getWindow());

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("ScoreChart.fxml"));
			BarChart barChart = (BarChart) parent.lookup("#barChart");
			XYChart.Series<String, Integer> seriesKorean = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasKorean = FXCollections.observableArrayList();
			XYChart.Series<String, Integer> seriesMath = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasMath = FXCollections.observableArrayList();
			XYChart.Series<String, Integer> seriesEnglish = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasEnglish = FXCollections.observableArrayList();

			for (int i = 0; i < scores.size(); i++) {
				datasKorean.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getKorean()));
				datasMath.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getMath()));
				datasEnglish.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getEnglish()));
			}
			seriesKorean.setData(datasKorean);
			seriesMath.setData(datasMath);
			seriesEnglish.setData(datasEnglish);
			barChart.setData(FXCollections.observableArrayList(seriesKorean, seriesMath, seriesEnglish));
			Scene scene = new Scene(parent);
			chartStage.setScene(scene);
			chartStage.setResizable(false);
			chartStage.show();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
