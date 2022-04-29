package Solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public Optional<User> findByLoginAndPassword(String login, String password);

	
	/*
	@Query("SELECT memo FROM User u WHERE u.idUser = ?1")
	public Optional<String> getMemoByIdUser(Long idUser);

	@Query("Select memo FROM User u")
	public Iterable<String> getAllMemo();

	@Query("UPDATE User u SET u.extMemo = ?2 WHERE u.idUser = ?1")
	public void writeMemo(Long idUser, String memo);
	*/

}
