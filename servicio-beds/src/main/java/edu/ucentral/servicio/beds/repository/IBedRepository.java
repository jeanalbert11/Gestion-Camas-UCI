package edu.ucentral.servicio.beds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.ucentral.servicio.beds.model.Bed;
import edu.ucentral.servicio.beds.model.Hospital;

public interface IBedRepository extends JpaRepository<Bed, Long> {

	// Obtener camas por hospital
	// @Query("select h from Hospital h join fetch h.unit u join fetch u.bed b where
	// h.id=?1")
	// public Iterable<Hospital> findBedsByHospital(Long hospitalId);

	// Obtener camas por uci
	//@Query("select b from Bed b join fetch b.")
	 //public Iterable<Hospital> findBedsByHospital(Long hospitalId);
}
