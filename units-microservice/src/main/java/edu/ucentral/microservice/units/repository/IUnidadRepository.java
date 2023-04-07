package edu.ucentral.microservice.units.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucentral.microservice.units.model.Unit;

public interface IUnidadRepository extends JpaRepository<Unit, Long> {
	//@Query("select b from Bed b where h.")
	//Buscar camas por uci
	//Listar Uci por id 
}
