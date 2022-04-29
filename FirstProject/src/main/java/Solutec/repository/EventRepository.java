package Solutec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Solutec.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

	public List<Event> findByDateBefore(Date date1);
	
}
