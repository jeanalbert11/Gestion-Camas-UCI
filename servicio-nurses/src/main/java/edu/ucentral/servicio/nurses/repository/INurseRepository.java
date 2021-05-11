package edu.ucentral.servicio.nurses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucentral.commons.nurses.model.Nurse;

public interface INurseRepository extends JpaRepository<Nurse, Long>{

}
