package ma.ajTelecom.stage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ajTelecom.stage.entities.Appareil;

public interface AppareilRepository extends JpaRepository<Appareil, Integer> {
	Appareil findByImei(int imei);

	Appareil findById(int id);
}
