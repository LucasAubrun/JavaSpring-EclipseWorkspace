package Solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Crée les constructeurs et les getter/setter
@NoArgsConstructor @AllArgsConstructor @Data
//Crée la table avec ses attributs dans la database
@Entity
public class Address {
	//Définit l'attribut en dessous comme clé primaire et la rend auto-générée
	@Id @GeneratedValue 
	private Long id;
	private String rue;
	private String codePostal;
	private String ville;
	
}
