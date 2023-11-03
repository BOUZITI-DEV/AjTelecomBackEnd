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

import ma.ajTelecom.stage.entities.Adresse;
import ma.ajTelecom.stage.repositories.AdresseRepository;
import ma.ajTelecom.stage.repositories.VilleRepository;

@RestController
@RequestMapping("api/adresse")
public class AdresseController {
	@Autowired
	private AdresseRepository adresseRepository;
	@Autowired
	private VilleRepository villeRepository;

	@GetMapping("find/{id}")
	public Adresse findById(@PathVariable(required = true) String id) {
		return adresseRepository.findById(Integer.parseInt(id));
	}

	@GetMapping("findAll")
	public List<Adresse> findAll() {
		return adresseRepository.findAll();
	}

	@PostMapping("save")
	public void save(@RequestBody Adresse adresse) {
		if(adresse.getVille().getId() == 0)
			villeRepository.save(adresse.getVille());	
		adresseRepository.save(adresse);
	}

	@PatchMapping("patch")
	public void patch(@RequestBody Adresse adresse) {
		adresseRepository.save(adresse);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Adresse adresse = adresseRepository.findById(Integer.parseInt(id));
		adresseRepository.delete(adresse);
	}

	@GetMapping("count")
	public long count() {
		return adresseRepository.count();
	}

}
