package edu.ucentral.servicio.beds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.ucentral.servicio.beds.model.Bed;

public interface IBedRepository extends JpaRepository<Bed, Long> {
	

}
