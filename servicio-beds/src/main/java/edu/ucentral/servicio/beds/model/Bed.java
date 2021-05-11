package edu.ucentral.servicio.beds.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.ucentral.commons.patients.model.Patient;
//import edu.ucentral.servicio.medical.staff.model.Doctor;
//import edu.ucentral.servicio.medical.staff.model.Nurse;
import edu.ucentral.commons.nurses.model.Nurse;

@Entity
@Table(name = "beds")
public class Bed implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3439782198412131077L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Campo vacio")
	@Size(min = 3, max = 20, message = "El número de caracteres debe estar entre 3 y 20")
	private String codigo;

	@NotNull
	private Boolean estado;
	
	//adicionar fecha, solo tenga relacionado 

	// Muchas camas asociadasa Una UCI
	// @ManyToOne
	// private Unit unit;

	// Una Cama esta asociada a un Unico Paciente
	// @NotNull
	@OneToOne
	@JoinColumn(name = "paciente_id")
	// @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Patient patient;

	@NotNull
	// @JsonIgnoreProperties(value = {"beds"}, allowSetters = true)
	// Muchas camas estan asociadas a una enfermera
	@ManyToOne
	// @JoinColumn(name = "nurse_id", referencedColumnName = "id", foreignKey =
	// @ForeignKey(nam))
	private Nurse nurse;

	public Bed() {
		// this.patients = new ArrayList<Patient>();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void addPatient(Patient patient) {
		this.patient = patient;
	}

	/*
	 * public Unit getUnit() { return unit; }
	 * 
	 * public void setUnit(Unit unit) { this.unit = unit; }
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nurse == null) ? 0 : nurse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bed other = (Bed) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nurse == null) {
			if (other.nurse != null)
				return false;
		} else if (!nurse.equals(other.nurse))
			return false;
		return true;
	}

}
