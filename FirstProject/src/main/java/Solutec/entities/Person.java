package Solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Person {
	
	@Id @GeneratedValue
	private Long id_client;
	private String nom;
	private String prenom;
	private Integer age;
	
	// Clé étrangère
	// Plusieurs personnes peuvent avoir la même adresse
	// Une personne a UNE adresse maximum
	@ManyToOne
	private Address adresse;

}
