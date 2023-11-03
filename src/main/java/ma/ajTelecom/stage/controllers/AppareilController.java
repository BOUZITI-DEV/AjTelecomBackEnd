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

import ma.ajTelecom.stage.entities.Appareil;
import ma.ajTelecom.stage.repositories.AppareilRepository;

@RestController
@RequestMapping("api/appareil")
public class AppareilController {
	@Autowired
	private AppareilRepository appareilRepository;

	@GetMapping("find/{id}")
	public Appareil findById(@PathVariable(required = true) String id) {
		return appareilRepository.findById(Integer.parseInt(id));
	}

	@GetMapping("find/{imei}")
	public Appareil findByImei(@PathVariable(required = true) String imei) {
		return appareilRepository.findByImei(Integer.parseInt(imei));
	}

	@GetMapping("findAll")
	public List<Appareil> findAll() {
		return appareilRepository.findAll();
	}

	@PostMapping("save")
	public void save(@RequestBody Appareil appareil) {
		appareilRepository.save(appareil);
	}

	@PatchMapping("patch")
	public void patch(@RequestBody Appareil appareil) {
		appareilRepository.save(appareil);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Appareil appareil = appareilRepository.findById(Integer.parseInt(id));
		appareilRepository.delete(appareil);
	}

	@GetMapping("count")
	public long count() {
		return appareilRepository.count();
	}

}
