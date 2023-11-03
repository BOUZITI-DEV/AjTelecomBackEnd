package ma.ajTelecom.stage.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Client extends Personne {
	@Column(unique = true)
	private String cin;

	public Client() {
		super();
	}

	public Client(int id, String nom, String prenom, String email, String telPortable, String telFixe, Adresse adresse,
			String cin) {
		super(id, nom, prenom, email, telPortable, telFixe, adresse);
		this.cin = cin;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	@Override
	public String toString() {
		return "Client [cin=" + cin + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", telPortable=" + telPortable + ", telFixe=" + telFixe + ", adresse=" + adresse + "]";
	}

}
