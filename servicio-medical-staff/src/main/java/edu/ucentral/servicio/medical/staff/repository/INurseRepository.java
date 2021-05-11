package edu.ucentral.servicio.medical.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ucentral.servicio.medical.staff.model.Nurse;

@Repository
public interface INurseRepository extends JpaRepository<Nurse, Long> {

}
