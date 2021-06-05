package edu.ucentral.servicio.beds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.ucentral.servicio.beds.model.Hospital;

public interface IHospitalRepository extends JpaRepository<Hospital, Long> {

	// Obtener camas por hospital
	//@Query("select h from Hospital h join fetch h.units u join fetch u.beds b where h.id=?1 and b.estado=?2")
	//public Iterable<Hospital> findHospitalByIdByBedEstado(Long hospitalId, boolean estado);

}
