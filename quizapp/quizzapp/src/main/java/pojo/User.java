package pojo;

import org.springframework.stereotype.Component;

import dao.LoginAndRegisterTransaction;

@Component
public class User {

	private String name;

	private String number;

	private String password;

	private String email;

	private int uniqueID;

	public User() {
	}
	public static void valueChanger() {
		LoginAndRegisterTransaction.user=null;
	}

	public User(String name, String number, String password, String email, int uniqueID) {
		this.name = name;
		this.number = number;
		this.password = password;
		this.email = email;
		this.uniqueID = uniqueID;
	}

	public User(String name, String number, String password, String email) {
		this.name = name;
		this.number = number;
		this.password = password;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", number=" + number + ", password=" + password + ", email=" + email
				+ ", uniqueID=" + uniqueID + "]";
	}

}
