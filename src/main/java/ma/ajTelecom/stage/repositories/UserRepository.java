package ma.ajTelecom.stage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ajTelecom.stage.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findById(int id);
	User findByLogin(String login);
	User findByRole(String role);
	
}
