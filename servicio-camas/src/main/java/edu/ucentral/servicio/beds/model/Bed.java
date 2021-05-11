package edu.ucentral.servicio.beds.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.ucentral.servicio.nurses.model.Nurse;

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

	/*
	 * @NotNull
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "id_asignatura") private Patient patient;
	 */

	@NotNull
	// @JsonIgnoreProperties(value = {"beds"}, allowSetters = true)
	// Muchas camas estan asociadas a una enfermera
	
	@ManyToOne
	@JoinColumn(name = "nurse_id")
	private Nurse nurse;

	/*
	 * @OneToOne private Uci uci;
	 * 
	 */

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

}
