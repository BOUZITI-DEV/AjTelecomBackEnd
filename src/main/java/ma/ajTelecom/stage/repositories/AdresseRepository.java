package ma.ajTelecom.stage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;	

import ma.ajTelecom.stage.entities.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
	Adresse findById(int id);
}
