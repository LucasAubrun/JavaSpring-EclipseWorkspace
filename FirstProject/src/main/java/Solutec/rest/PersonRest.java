
package Solutec.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Solutec.entities.Person;
import Solutec.repository.PersonRepository;

@RestController @CrossOrigin("*")
public class PersonRest {
	
	@Autowired
	private PersonRepository personRepo;
	
	// Effectue un SELECT* dans person automatiquement
	// @GetMapping permet de lancer cette fonction dans une requête HTTP GET
	@GetMapping("person")
	public Iterable<Person> allPerson() {
		return personRepo.findAll();
	}
	
	@PostMapping("person")
	public Person savePerson(@RequestBody Person p) {
		return personRepo.save(p);
	}

	@GetMapping("person/{id}")
	public Optional<Person> onePersonById(@PathVariable Long id) {
		return personRepo.findById(id);
	}
	
	@DeleteMapping("person/{id}")
	public boolean deletePerson(@PathVariable Long id) {
		Optional<Person> p = personRepo.findById(id);
		if (p.isPresent()) {
			personRepo.deleteById(id);
			return true;
		}
		else
			return false;
	}
	
	@PutMapping("person/{id}")
	public Person modifPerson(@RequestBody Person p, @PathVariable Long id) {
		p.setId_client(id);
		return personRepo.save(p);
	}
	
	@GetMapping("person/nom/{nom}")
	public List<Person> onePersonByNom(@PathVariable String nom) {
		return personRepo.findByNom(nom);
	}
	
	@GetMapping("person/adresse/id/{id}")
	public List<Person> OnePersonByAdresseId(@PathVariable Long id) {
		return personRepo.findByAdresseId(id);
	}
}
