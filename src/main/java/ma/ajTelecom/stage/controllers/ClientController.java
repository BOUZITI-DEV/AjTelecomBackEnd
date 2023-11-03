package ma.ajTelecom.stage.controllers;

import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.ajTelecom.stage.entities.Client;
import ma.ajTelecom.stage.repositories.AdresseRepository;
import ma.ajTelecom.stage.repositories.ClientRepository;

@RestController
@RequestMapping("api/client")
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AdresseRepository adresseRepository;

	@GetMapping("find/{id}")
	public Client findById(@PathVariable(required = true) String id) {
		return clientRepository.findById(Integer.parseInt(id));
	}

	@GetMapping("findAll")
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@PostMapping("save")
	public void save(@RequestBody Client client) {
		if(client.getAdresse().getId() == 0)
			adresseRepository.save(client.getAdresse());
		clientRepository.save(client);
	}

	@PatchMapping("patch")
	public void patch(@RequestBody Client client) {
		clientRepository.save(client);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Client client = clientRepository.findById(Integer.parseInt(id));
		clientRepository.delete(client);
	}

	@GetMapping("count")
	public long count() {
		return clientRepository.count();
	}

}
