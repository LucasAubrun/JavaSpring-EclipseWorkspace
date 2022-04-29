package Solutec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Solutec.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	
	// Les deux sont équivalents
	// Le premier marche par convention
	// Le second, toute la commande est définie
	
	public List<Person> findByNom(String nom);
	
	@Query("SELECT p FROM Person p WHERE p.nom = ?1")
	public List<Person> getPersonByNom(String nom);
	
	public List<Person> findByAdresseId(Long idUser);
	
}
