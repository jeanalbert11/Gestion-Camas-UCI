package edu.ucentral.servicio.medical.staff.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "nurses")
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_nurse_person"))
@OnDelete(action = OnDeleteAction.CASCADE) // Elimina en cascada: Osea si borro nurse => se borra enfermera
public class Nurse extends Person {

	private static final long serialVersionUID = 1L;

	private String tipo;

	public Nurse() {

	}

	public Nurse(Long id, String cedula, String tarjetaProfesional, String nombre, String apellido, String tipo) {
		super(id, cedula, tarjetaProfesional, nombre, apellido);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
