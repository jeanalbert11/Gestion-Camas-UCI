package edu.ucentral.microservice.beds.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.ucentral.commons.beds.model.HistoryAssignment;

public interface IHistoryAssignmentRepository extends PagingAndSortingRepository<HistoryAssignment, Long> {
	//@Query("select h from HistoryAssignment h join fetch h.patient p where p.id=?1")
	//public HistoryAssignment findBedByPatientId(Long id);
}
