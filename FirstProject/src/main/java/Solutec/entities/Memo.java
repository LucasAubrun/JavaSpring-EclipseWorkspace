package Solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Memo {
	
	@Id @GeneratedValue
	private Long idMemo;
	private String content;
	
	@CreationTimestamp
	private Date date;
	
	@ManyToOne
	private User writer;
	@ManyToOne
	private User reader;
}
