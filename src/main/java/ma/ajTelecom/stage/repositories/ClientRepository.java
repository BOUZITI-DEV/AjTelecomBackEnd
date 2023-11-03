package ma.ajTelecom.stage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ajTelecom.stage.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client findById(int id);
}
