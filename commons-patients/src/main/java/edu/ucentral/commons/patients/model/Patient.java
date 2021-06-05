package edu.ucentral.commons.patients.model;

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
import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.patients.model.Patient;

@Entity
@Table(name = "patients")
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "campo vacio")
	private String cedula;

	@NotEmpty(message = "campo vacio")
	@Size(min = 3, max = 20, message = "el número de caracteres debe estar entre 3 y 20")
	private String nombre;

	@NotEmpty(message = "campo vacio")
	@Size(min = 3, max = 20, message = "el número de caracteres debe estar entre 3 y 20")
	private String apellido;

	@NotEmpty(message = "campo vacio")
	@Email(message = "no es una dirección  de correo valido")
	private String correo;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	// @OneToMany(mappedBy = "patient")
	//Set<HistoryAssignment> historyAssignments;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(Long id, @NotEmpty(message = "campo vacio") String cedula, String nombre, String apellido,
			String correo, Date fechaCreacion) {
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

	// secretariaacademicaficb@ucentral.edu.co
	// direccioningenieriadesistemas@ucentral.edu.co

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
