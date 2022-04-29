package Solutec.rest;

import java.util.Date;
import java.util.Optional;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Solutec.entities.Memo;
import Solutec.repository.MemoRepository;

@RestController @CrossOrigin("*")
public class MemoRest {
	
	@Autowired
	private MemoRepository memoRepo;
	
	
	@PostMapping("memo")
	public Memo saveUser(@RequestBody Memo m) {
		return memoRepo.save(m);
	}
	
	@GetMapping("memo/{idUser}")
	public Iterable<Memo> getMemoByReaderIdUser(@PathVariable Long idUser) {
		return memoRepo.findByReaderIdUser(idUser);
	}
	
	@GetMapping("memoString/{idUser}")
	public Iterable<String> getMemoString(@PathVariable Long idUser) {
		return memoRepo.getMemoStringByReader(idUser);
	}
	
	@GetMapping("memo/all")
	public Iterable<Memo> getAll() {
		return memoRepo.findAll();
	}
	
	@PostMapping("memo/write")
	public Memo writeMemo(@RequestBody Memo memo) {
		return memoRepo.save(memo);
	}
	
	@PostMapping("memo/public/write")
	public Memo writeMemoPublic(@RequestBody Memo memo) {
		memo.setReader(null);
		return memoRepo.save(memo);
	}
	
	@PostMapping("memo/delete/{idMemo}")
	public boolean deleteMemoByIdMemo(@PathVariable Long idMemo) {
		Optional<Memo> memo = memoRepo.findByIdMemo(idMemo);
		if (memo.isPresent()) {
			memoRepo.deleteById(idMemo);
			return true;
		}
		else 
			return false;
	}
	
	@GetMapping("memo/all/public")
	public Iterable<Memo> getMemoPublic() {
		return memoRepo.findByReaderIsNull();
	}

}
