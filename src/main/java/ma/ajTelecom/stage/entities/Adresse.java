package ma.ajTelecom.stage.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String label;
	private double latitude;
	private double longitude;
	private String type;
	@ManyToOne
	private Ville ville;
	public Adresse() {
		super();
	}
	public Adresse(int id, String label, double latitude, double longitude, String type, Ville ville) {
		super();
		this.id = id;
		this.label = label;
		this.latitude = latitude;
		this.longitude = longitude;
		this.type = type;
		this.ville = ville;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", label=" + label + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", type=" + type + ", ville=" + ville + "]";
	}
	
	
}
