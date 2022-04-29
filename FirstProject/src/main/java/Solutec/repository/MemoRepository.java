package Solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Solutec.entities.Memo;

public interface MemoRepository extends CrudRepository<Memo, Long> {
	
	public List<Memo> findByWriterIdUser(Long idUser);
	
	public List<Memo> findByReaderIdUser(Long idUser);
	
	@Query("SELECT m.content FROM Memo m WHERE m.reader.idUser = ?1")
	public List<String> getMemoStringByReader(Long idUser);

	public Optional<Memo> findByIdMemo(Long idMemo);
	
	public List<Memo> findByReaderIsNull(); //public List<Memo> findByPublicIsFalse / findByPublicIsTrue si on ajoute une colonne publique/privé
	
}
