package ma.ajTelecom.stage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ajTelecom.stage.entities.Installation;

public interface InstallationRepository extends JpaRepository<Installation, Integer> {
	Installation findById(int id);
}
