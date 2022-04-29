package Solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Solutec.entities.User;
import Solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class UserRest {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("userById/{id}")
	public Optional<User> onePersonById(@PathVariable Long idUser) {
		return userRepo.findById(idUser);
	}
	
	@PostMapping("user/loginAndPassword")
	public Optional<User> getUser(@RequestBody User u) {
		return userRepo.findByLoginAndPassword(u.getLogin(), u.getPassword());
	}
	
	@PostMapping("user")
	public User saveUser(@RequestBody User u) {
		return userRepo.save(u);
	}
	
	@GetMapping("all")
	public Iterable<User> getAll() {
		return userRepo.findAll();
	}
	
}
