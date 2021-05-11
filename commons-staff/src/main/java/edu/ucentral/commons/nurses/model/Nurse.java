package edu.ucentral.commons.nurses.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
/*
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
*/
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "nurses")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Nurse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3493669900525956719L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Campo vacio")
	private String cedula;
	@NotEmpty(message = "Campo vacio")
	@Column(name = "tarjeta_profesional")
	private String tarjetaProfesional;
	@NotEmpty(message = "Campo vacio")
	@Size(min = 3, max = 20, message = "El número de caracteres debe estar entre 3 y 20")
	private String nombre;
	@NotEmpty(message = "Campo vacio")
	@Size(min = 3, max = 20, message = "El número de caracteres debe estar entre 3 y 20")
	private String apellido;
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	//@JsonIgnore
	//@Lob
	//private byte[] imagen;

	// @JsonIgnoreProperties(value = { "nurses" })
	// @OneToMany(mappedBy = "nurse", fetch = FetchType.LAZY, cascade =
	// CascadeType.ALL, orphanRemoval = true)
	// private List<Beds> beds;

	public Nurse(Long id, String cedula, String tarjetaProfesional, String nombre, String apellido /*,  byte[] imagen*/) {
		this.id = id;
		this.cedula = cedula;
		this.tarjetaProfesional = tarjetaProfesional;
		this.nombre = nombre;
		this.apellido = apellido;
		//this.imagen = imagen;

	}


	
	public Nurse() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public Nurse() { this.beds = new ArrayList<Bed>(); }
	 */
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

	public String getTarjetaProfesional() {
		return tarjetaProfesional;
	}

	public void setTarjetaProfesional(String tarjetaProfesional) {
		this.tarjetaProfesional = tarjetaProfesional;
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
/*
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	*/
/*
	public int getImagenHashCode() {
		return (imagen != null) ? imagen.hashCode() : null;
	}
*/
}
