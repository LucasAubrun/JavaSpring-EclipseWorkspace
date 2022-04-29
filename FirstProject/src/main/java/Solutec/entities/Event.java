package Solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Event {
	
	@Id @GeneratedValue
	private Long id;
	private Date date;
	private String text;
}
