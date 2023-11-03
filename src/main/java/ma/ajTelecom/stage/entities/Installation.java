package ma.ajTelecom.stage.entities;
	

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Installation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
	private String type;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Technicien technicien;
	@ManyToOne
	private Appareil appareil;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	private Adresse adresse;

	public Installation() {
		super();
	}

	public Installation(int id, Date date, String type, Client client, Technicien technicien, Appareil appareil,
			Adresse adresse) {
		super();
		this.id = id;
		this.date = date;
		this.type = type;
		this.client = client;
		this.technicien = technicien;
		this.appareil = appareil;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Technicien getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
	}

	public Appareil getAppareil() {
		return appareil;
	}

	public void setAppareil(Appareil appareil) {
		this.appareil = appareil;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Installation [id=" + id + ", date=" + date + ", type=" + type + ", client=" + client + ", technicien="
				+ technicien + ", appareil=" + appareil + ", adresse=" + adresse + "]";
	}

}
