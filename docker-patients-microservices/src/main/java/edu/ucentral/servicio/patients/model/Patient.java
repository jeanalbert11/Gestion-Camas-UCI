package edu.ucentral.servicio.patients.model;

//secretariaacademicaficb@ucentral.edu.co
//direccioningenieriadesistemas@ucentral.edu.co
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import edu.ucentral.servicio.patients.model.Patient;

@Entity
@Table(name = "patients")
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "empty field")
	private String cedula;

	@NotEmpty(message = "empty field")
	@Size(min = 3, max = 20, message = "the number of character must be between 3 and 20")
	private String nombre;

	@NotEmpty(message = "campo vacio")
	@Size(min = 3, max = 20, message = "the number of character must be between 3 and 20")
	private String apellido;

	@NotEmpty(message = "empty field")
	@Email(message = "It's not a valid email address")
	private String correo;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	// @OneToMany(mappedBy = "patient")
	// Set<HistoryAssignment> historyAssignments;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(Long id, String cedula, String nombre, String apellido, String correo, Date fechaCreacion) {
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaCreacion = fechaCreacion;
	}

	@PrePersist
	void prePersist() {
		fechaCreacion = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
