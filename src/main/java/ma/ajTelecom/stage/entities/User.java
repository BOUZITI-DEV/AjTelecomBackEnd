package ma.ajTelecom.stage.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
public class User extends Personne {
	@Column(unique = true)
	protected String login;
	protected String passwd;
	protected String role;

	public User() {
		super();
	}

	public User(int id, String nom, String prenom, String email, String telPortable, String telFixe, Adresse adresse,
			String login, String passwd, String role) {
		super(id, nom, prenom, email, telPortable, telFixe, adresse);
		this.login = login;
		this.passwd = passwd;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", passwd=" + passwd + ", role=" + role + "]";
	}

}
