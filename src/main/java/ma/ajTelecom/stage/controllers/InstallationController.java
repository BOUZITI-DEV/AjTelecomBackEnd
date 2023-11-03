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
import ma.ajTelecom.stage.entities.Installation;
import ma.ajTelecom.stage.repositories.AdresseRepository;
import ma.ajTelecom.stage.repositories.InstallationRepository;

@RestController
@RequestMapping("api/installation")
public class InstallationController {
	@Autowired
	private InstallationRepository installationRepository;
	@Autowired
	private AdresseRepository adresseRepository;

	@GetMapping("find/{id}")
	public Installation findById(@PathVariable(required = true) String id) {
		return installationRepository.findById(Integer.parseInt(id));
	}

	@GetMapping("findAll")
	public List<Installation> findAll() {
		return installationRepository.findAll();
	}

	@PostMapping("save")
	public void save(@RequestBody Installation installation) {
		if(installation.getAdresse().getId() == 0)
			adresseRepository.save(installation.getAdresse());
		installationRepository.save(installation);
	}

	@PatchMapping("patch")
	public void patch(@RequestBody Installation installation) {
		installationRepository.save(installation);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Installation installation = installationRepository.findById(Integer.parseInt(id));
		installationRepository.delete(installation);
	}

	@GetMapping("count")
	public long count() {
		return installationRepository.count();
	}

}
