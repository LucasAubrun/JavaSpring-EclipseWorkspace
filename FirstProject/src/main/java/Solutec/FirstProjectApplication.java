package Solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Solutec.entities.Address;
import Solutec.entities.Event;
import Solutec.entities.Memo;
import Solutec.entities.Person;
import Solutec.entities.User;
import Solutec.repository.AddressRepository;
import Solutec.repository.EventRepository;
import Solutec.repository.MemoRepository;
import Solutec.repository.PersonRepository;
import Solutec.repository.UserRepository;

@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner {

	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private PersonRepository personRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MemoRepository memoRepo;
	@Autowired
	private EventRepository eventRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
		System.out.println("Lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Lancement en cours");
		
		Address a1 = new Address(null, "36 avenue Pierre", "92240", "Malakoff");
		Address a2 = new Address(null, "18 rue de l'An", "3615", "Edinburg");
		addressRepo.save(a1);
		addressRepo.save(a2);
		
		Person p1 = new Person(null, "Aubrun", "Lucas", 14, a1);
		Person p2 = new Person(null, "Raison", "Clara", 149, a1);
		Person p3 = new Person(null, "Sergeant", "Dylan", 8, a1);
		personRepo.save(p1);
		personRepo.save(p2);
		personRepo.save(p3);
		
		User u1 = new User(null, "Lucas", "LePot");
		User u2 = new User(null, "Clara", "klawa");
		userRepo.save(u1);
		userRepo.save(u2);
		
		DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = d.parse("14/01/1997");
		Date date2 = d.parse("29/02/2002");
		Date date3 = d.parse("29/02/2025");
		
		Memo m1 = new Memo(null, "Aujourd'hui, je suis au régime", null, u1, u1);
		Memo m2 = new Memo(null, "Demain je mangerai un gâteau", null, u2, u1);
		Memo m3 = new Memo(null, "Samedi j'me pète le bide", null, u2, null);
		memoRepo.save(m1);
		memoRepo.save(m2);
		memoRepo.save(m3);
		
		Event e1 = new Event(null, date1, "Pyjama Party");
		Event e2 = new Event(null, date2, "Grosse orgie");
		Event e3 = new Event(null, date3, "Explosion de la Terre");
		eventRepo.save(e1);
		eventRepo.save(e2);
		eventRepo.save(e3);
	}

}
