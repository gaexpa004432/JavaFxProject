package input;

public class Board {
	private String title;
	private String Password;
	private String publicity;
	private String exitDate;
	private String content;
	public Board(String title, String password, String publicity, String exitDate, String content) {
		this.title = title;
		this.Password = password;
		this.publicity = publicity;
		this.exitDate = exitDate;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public String getPassword() {
		return Password;
	}
	public String getPublicity() {
		return publicity;
	}
	public String getExitDate() {
		return exitDate;
	}
	public String getContent() {
		return content;
	}
	
	
}
