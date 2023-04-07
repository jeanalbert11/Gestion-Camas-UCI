package edu.ucentral.microservice.beds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

//import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.beds.model.Bed;

public interface IBedRepository extends PagingAndSortingRepository<Bed, Long> {

	@Query("SELECT b FROM Bed b WHERE b.code LIKE %?1%")
	public List<Bed> findByCode(String code);

	@Query("SELECT b FROM  Bed b WHERE b.state = ?1")
	public List<Bed> findByState(boolean state);

	// Camas Asignadas
	// @Query("select b.id from Bed b join b.patient p where p.id=?1 group by b.id")
	// public Iterable<Long> findBedsIdsAssignedToPaciente(Long pacienteId);

	// Obtener camas por uci
	// @Query("select b from Bed b join fetch b.")
	// public Iterable<Hospital> findBedsByHospital(Long hospitalId);

	@Modifying
	@Query("delete ha FROM  HistoryAssignment ha where ha.patient = ?1")
	public void deleteHistoryAssignmentById(Long id);

	@Modifying
	@Query("delete ha FROM  HistoryAssignment ha where ha.patient = ?1")
	public void deletePatientByIdFromPatientsMicroservice(Long id);

	@Modifying
	@Query("delete ha FROM  HistoryAssignment ha where ha.patient = ?1")
	public void deletePatientByIdDistributed(Long id);

	@Modifying
	@Query("delete ha FROM  HistoryAssignment ha where ha.patient = ?1")
	public void deletePatientDistributed(Long id);
}
