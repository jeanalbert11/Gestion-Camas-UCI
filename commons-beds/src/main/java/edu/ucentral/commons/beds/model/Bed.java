package edu.ucentral.commons.beds.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import edu.ucentral.commons.patients.model.Patient;
//import edu.ucentral.servicio.medical.staff.model.Doctor;
//import edu.ucentral.servicio.medical.staff.model.Nurse;
import edu.ucentral.commons.nurses.model.Nurse;

@Entity
@Table(name = "beds")
public class Bed implements Serializable {

	private static final long serialVersionUID = -3439782198412131077L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "campo vacio")
	@Size(min = 3, max = 20, message = "el número de caracteres debe estar entre 3 y 20")
	private String codigo;

	// Muchas camas estan asociadas a una enfermera
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Nurse nurse;

	@OneToMany(mappedBy = "bed")
	Set<HistoryAssignment> historyAssignments;

	public Bed() {

	}

	public Bed(Long id, String room, Nurse nurse) {
		this.id = id;
		this.codigo = room;
		this.nurse = nurse;
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

	public void setCodigo(String room) {
		this.codigo = room;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

}
