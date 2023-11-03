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
import ma.ajTelecom.stage.entities.Technicien;
import ma.ajTelecom.stage.repositories.AdresseRepository;
import ma.ajTelecom.stage.repositories.TechnicienRepository;

@RestController
@RequestMapping("api/technicien")
public class TechnicienController {
	@Autowired
	private TechnicienRepository technicienRepository;
	@Autowired
	private AdresseRepository adresseRepository;

	@GetMapping("find/{id}")
	public Technicien findById(@PathVariable(required = true) String id) {
		return technicienRepository.findById(Integer.parseInt(id));
	}

	@GetMapping("findAll")
	public List<Technicien> findAll() {
		return technicienRepository.findAll();
	}

	@PostMapping("save")
	public void save(@RequestBody Technicien technicien) {
		if(technicien.getAdresse().getId() == 0)
			adresseRepository.save(technicien.getAdresse());
		technicienRepository.save(technicien);
	}

	@PatchMapping("patch")
	public void patch(@RequestBody Technicien technicien) {
		technicienRepository.save(technicien);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Technicien technicien = technicienRepository.findById(Integer.parseInt(id));
		technicienRepository.delete(technicien);
	}

	@GetMapping("count")
	public long count() {
		return technicienRepository.count();
	}

}
