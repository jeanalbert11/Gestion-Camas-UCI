package edu.ucentral.servicio.patients.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import edu.ucentral.commons.patients.model.Address;

public interface IAddressRepository extends PagingAndSortingRepository<Address, Long> {

	@Query("Select a from Address a where a.patient = ?1 ")
	Optional<Address> findByUserId(Long id);
}
