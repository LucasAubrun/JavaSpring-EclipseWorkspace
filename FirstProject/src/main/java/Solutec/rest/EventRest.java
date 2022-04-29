package Solutec.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Solutec.entities.Event;
import Solutec.entities.Person;
import Solutec.repository.EventRepository;

@RestController @CrossOrigin("*")
public class EventRest {

	@Autowired
	private EventRepository eventRepo;
	
	@PostMapping("event")
	public Event saveEvent(@RequestBody Event e) {
		return eventRepo.save(e);
	}
	
	@GetMapping("event/passe")
	public Iterable<Event> getEventBefore() {
		//date actuelle
		Date date = new Date();
		return eventRepo.findByDateBefore(date);
	}
	
	@GetMapping("event/all")
	public Iterable<Event> getAll() {
		return eventRepo.findAll();
	}
}
