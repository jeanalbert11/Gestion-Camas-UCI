package edu.ucentral.servicio.nurses.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_doctor_person"))
@OnDelete(action = OnDeleteAction.CASCADE) // Elimina en cascada: Osea si borro doctor => se borra enfermera
public class Doctor extends Person {

	private static final long serialVersionUID = 1L;

	private String especialidad;// Especialidad de la medicina: Vigila todas las enfermedades

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(Long id, String cedula, String tarjetaProfesional, String nombre, String apellido,
			String especialidad) {
		super(id, cedula, tarjetaProfesional, nombre, apellido);
		this.especialidad = especialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
