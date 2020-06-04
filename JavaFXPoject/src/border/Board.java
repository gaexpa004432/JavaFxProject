package border;

import javafx.beans.property.SimpleStringProperty;

public class Board {//사용안함
	private SimpleStringProperty title;
	private SimpleStringProperty Password;
	private SimpleStringProperty publicity;
	private SimpleStringProperty exitDate;
	private SimpleStringProperty content;
	public Board(String title) {
		this.title = new SimpleStringProperty(title);
	}
	public Board(String title, String publicity,
			String exitDate, String content) {
		this.title = new SimpleStringProperty(title);
		//this.Password = new SimpleStringProperty(password);
		this.publicity = new SimpleStringProperty(publicity);
		this.exitDate = new SimpleStringProperty(exitDate);
		this.content = new SimpleStringProperty(content);
	}
	public Board() {
		
	}
	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}
	
	public String getPassword() {
		return Password.get();
	}

	public void setPassword(String password) {
		this.Password.set(password);
	}
	public void setPublicity(String publicity) {
		this.publicity.set(publicity);
	}
	public String getPublicity() {
		return publicity.get();
	}
	public void setContent(String content) {
		this.content.set(content);
	}
	public String getContent() {
		return content.get();
	}
	public void setExitDate(String exitDate) {
		this.exitDate.set(exitDate);
	}
	public String getExitDate() {
		return exitDate.get();
	}
	
	
	public SimpleStringProperty titleProperty() {
		return this.title;
	}
	public SimpleStringProperty exitDateProperty() {
		return this.exitDate;
	}
	public SimpleStringProperty contentProperty() {
		return this.content;
	}
	public SimpleStringProperty publicityProperty() {
		return this.publicity;
	}
	public SimpleStringProperty PasswordProperty() {
		return this.Password;
	}

	

	
	
}
