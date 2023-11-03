package ma.ajTelecom.stage.controllers;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ajTelecom.stage.entities.User;
import ma.ajTelecom.stage.repositories.AdresseRepository;
import ma.ajTelecom.stage.repositories.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdresseRepository adresseRepository;

	@GetMapping("find/{id}")
	public User findById(@PathVariable(required = true) String id) {
		return userRepository.findById(Integer.parseInt(id));
	}

	@PostMapping("/authentification")
	public User authentication(@RequestBody User user) {
		User storedUser = userRepository.findByLogin(user.getLogin());
		if (storedUser != null && BCrypt.checkpw(user.getPasswd(), storedUser.getPasswd())) {
			return storedUser;
		}
		return null;
	}

	@GetMapping("findAll")
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		users.remove(userRepository.findByRole("superAdmin"));
		for (User u : users) {
			u.setPasswd(null);
		}
		return users;
	}

	@PostMapping("save")
	public void save(@RequestBody User user) {
		if (user.getAdresse() != null && user.getAdresse().getId() == 0)
			adresseRepository.save(user.getAdresse());
		user.setPasswd(BCrypt.hashpw(user.getPasswd(), BCrypt.gensalt()));
		userRepository.save(user);
	}

	@PatchMapping("patch")
	public void patch(@RequestBody User user) {
		User existingUser = userRepository.findById(user.getId());
		if (user.getPasswd() == null)
			user.setPasswd(existingUser.getPasswd());
		else {
			user.setPasswd(BCrypt.hashpw(user.getPasswd(), BCrypt.gensalt()));
		}
		userRepository.save(user);
	}
	
	@PatchMapping("patchCredentials")
	public void patchCredentials(@RequestBody User user) {
		User existingUser = userRepository.findById(user.getId());
		if (user.getPasswd() == null)
			user.setPasswd(existingUser.getPasswd());
		else {
			user.setPasswd(BCrypt.hashpw(user.getPasswd(), BCrypt.gensalt()));
			user.setNom(existingUser.getNom());
			user.setPrenom(existingUser.getPrenom());
			user.setEmail(existingUser.getEmail());
			user.setTelPortable(existingUser.getTelPortable());
			user.setTelFixe(existingUser.getTelFixe());
			user.setAdresse(existingUser.getAdresse());
		}
		userRepository.save(user);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		User user = userRepository.findById(Integer.parseInt(id));
		userRepository.delete(user);
	}

	@DeleteMapping("deleteAll")
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@GetMapping("count")
	public long count() {
		return userRepository.count();
	}

}
