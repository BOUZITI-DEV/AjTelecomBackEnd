package ma.ajTelecom.stage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ajTelecom.stage.entities.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Integer> {
	Technicien findById(int id);
}
