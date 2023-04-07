package edu.ucentral.commons.beds.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import edu.ucentral.commons.nurses.model.Nurse;
import edu.ucentral.commons.patients.model.Patient;

@Entity
@Table(name = "beds")
public class Bed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "campo vacio")
	@Size(min = 3, max = 20, message = "el número de caracteres debe estar entre 3 y 20")
	private String code;

	// Muchas camas estan asociadas a una enfermera
	@NotNull
	@ManyToOne // (fetch = FetchType.LAZY)
	// @JoinColumn(name = "nurse_id")
	private Nurse nurse;

	//@NotNull
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Patient> patients;

	private boolean state;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	public Bed() {

	}

	public Bed(Long id, String code, Nurse nurse, List<Patient> patients, boolean state, Date startDate, Date endDate) {
		this.id = id;
		this.code = code;
		this.nurse = nurse;
		this.patients = new ArrayList<>();
		this.state = state;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void addPatients(Patient patient) {
		patients.add(patient);
	}

	public void removePatient(Patient patient) {
		patients.remove(patient);

	}

}
