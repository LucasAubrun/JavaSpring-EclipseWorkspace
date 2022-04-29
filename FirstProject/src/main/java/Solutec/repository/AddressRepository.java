package Solutec.repository;

import org.springframework.data.repository.CrudRepository;

import Solutec.entities.Address;

public interface AddressRepository extends CrudRepository<Address,Long> {
	

}
