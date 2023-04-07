package edu.ucentral.commons.beds.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.ucentral.commons.nurses.model.Nurse;
import edu.ucentral.commons.patients.model.Patient;

@Entity
@Table(name = "beds")
public class Bed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "empty field")
	@Size(min = 3, max = 20, message = "the number of character must be between 3 and 20")
	private String code;

	private boolean state;

	// Muchas Camas estan asociadas a una Enermera
	@NotNull
	@ManyToOne // (fetch = FetchType.LAZY)
	// @JoinColumn(name = "nurse_id")
	private Nurse nurse;

	@Transient
	private List<Patient> patients;

	@JsonIgnoreProperties(value = { "bed" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bed", cascade = CascadeType.ALL, orphanRemoval = true)
	List<HistoryAssignment> historyAssignments;

	public Bed() {
		patients = new ArrayList<Patient>();
		historyAssignments = new ArrayList<HistoryAssignment>();
	}

	public Bed(Long id, String code, boolean state, @NotNull Nurse nurse) {
		this.id = id;
		this.code = code;
		this.state = state;
		this.nurse = nurse;
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

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
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

	public void addPatient(Patient patient) {
		this.patients.add(patient);
	}

	public void removePatient(Patient patient) {
		this.patients.remove(patient);
	}

	public List<HistoryAssignment> getHistoryAssignments() {
		return historyAssignments;
	}

	public void setHistoryAssignments(List<HistoryAssignment> historyAssignments) {
		this.historyAssignments = historyAssignments;
	}

	public void addHistoryAssignments(HistoryAssignment historyAssignment) {
		this.historyAssignments.add(historyAssignment);
	}

	public void removeHistoryAssignments(HistoryAssignment historyAssignment) {
		this.historyAssignments.remove(historyAssignment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Bed)) {
			return false;
		}
		Bed bed = (Bed) obj;
		return this.id != null && this.id.equals(bed.getId());
	}

}
