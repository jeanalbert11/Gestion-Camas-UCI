package edu.ucentral.microservice.beds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import edu.ucentral.commons.patients.model.Patient;

import edu.ucentral.commons.beds.model.Bed;

public interface IBedRepository extends JpaRepository<Bed, Long> {

	@Query("SELECT b FROM Bed b WHERE b.codigo LIKE %?1%")
	public List<Bed> findByCode(String code);

	//@Query("SELECT b FROM  Bed b WHERE b.estado=?1")
	//public List<Bed> findByEstate(boolean estado);

	// Camas Asignadas
	//@Query("select b.id from Bed b join b.patient p where p.id=?1 group by b.id")
	//public Iterable<Long> findBedsIdsAssignedToPaciente(Long pacienteId);

	// Obtener camas por uci
	// @Query("select b from Bed b join fetch b.")
	// public Iterable<Hospital> findBedsByHospital(Long hospitalId);
}
