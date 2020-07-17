package chart_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

public class ChartController implements Initializable{
	@FXML PieChart pieChart;
	@FXML BarChart<String,Integer> barChart;
	@FXML AreaChart areaChart;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	pieChart.setData(FXCollections.observableArrayList(
			new PieChart.Data("AWT", 10),
			new PieChart.Data("Swing",30),
			new PieChart.Data("SWT", 25),
			new PieChart.Data("JaavaFX", 35)
			));	
	
	XYChart.Series<String,Integer> series1 = new XYChart.Series<>();
	series1.setName("남자");
	series1.setData(FXCollections.observableArrayList(
			new XYChart.Data("2015",70),
			new XYChart.Data("2016",40),
			new XYChart.Data("2017",50),
			new XYChart.Data("2018",30)));
	XYChart.Series<String,Integer> series2 = new XYChart.Series<>();
	series2.setName("여자");
	series2.setData(FXCollections.observableArrayList(
			new XYChart.Data("2015",30),
			new XYChart.Data("2016",60),
			new XYChart.Data("2017",50),
			new XYChart.Data("2018",60)));
	barChart.getData().add(series1);
	barChart.getData().add(series2);
	
	XYChart.Series<String,Integer> series3 = new XYChart.Series<>();
	series3.setName("평균온도");
	series3.setData(FXCollections.observableArrayList(
			new XYChart.Data("2015",13),
			new XYChart.Data("2016",6),
			new XYChart.Data("2017",22),
			new XYChart.Data("2018",19)));
	areaChart.getData().add(series3);

	}
}
