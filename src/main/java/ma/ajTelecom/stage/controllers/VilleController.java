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
import ma.ajTelecom.stage.entities.Ville;
import ma.ajTelecom.stage.repositories.VilleRepository;

@RestController
@RequestMapping("api/ville")
public class VilleController {
	@Autowired
	private VilleRepository villeRepository;

	@GetMapping("find/{id}")
	public Ville findById(@PathVariable(required = true) String id) {
		return villeRepository.findById(Integer.parseInt(id));
	}

	@GetMapping("findAll")
	public List<Ville> findAll() {
		return villeRepository.findAll();
	}

	@PostMapping("save")
	public void save(@RequestBody Ville ville) {
		villeRepository.save(ville);
	}

	@PatchMapping("patch")
	public void patch(@RequestBody Ville ville) {
		villeRepository.save(ville);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Ville ville = villeRepository.findById(Integer.parseInt(id));
		villeRepository.delete(ville);
	}
	
	@DeleteMapping("deleteAll")
	public void deleteAll() {
		villeRepository.deleteAll();
	}

	@GetMapping("count")
	public long count() {
		return villeRepository.count();
	}

}
