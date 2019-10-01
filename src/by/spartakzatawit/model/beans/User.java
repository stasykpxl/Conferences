package by.spartakzatawit.model.beans;

//Класс бизнесс-модели
public class User {
	private int id;
	private String login;
	private String firstName;
	private String secondName;
	private String email;
	
	public User() {
		super();
	}

	public User(String login) {
		super();
		this.login = login;
	}
	
	public User(String login, String firstName, String secondName, String email) {
		super();
		this.login = login;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
	}
	
	public User(int id, String login, String firstName, String secondName, String email) {
		super();
		this.id = id;
		this.login = login;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
