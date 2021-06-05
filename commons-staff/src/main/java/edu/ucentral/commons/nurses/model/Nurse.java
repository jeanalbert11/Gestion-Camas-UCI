package edu.ucentral.commons.nurses.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
/*
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
*/
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "nurses")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Nurse implements Serializable {

	private static final long serialVersionUID = 3493669900525956719L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "campo vacio")
	private String cedula;

	@NotEmpty(message = "campo vacío")
	@Column(name = "tarjeta_profesional")
	private String tarjetaProfesional;

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

	@JsonIgnore
	@Lob
	private byte[] foto;

	/*
	 * @JsonIgnoreProperties(value = { "nurses" })
	 * 
	 * @OneToMany(mappedBy = "nurse", fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL, orphanRemoval = true) private List<Beds> beds;
	 */

	public Nurse() {
	}

	public Nurse(Long id, String cedula, String tarjetaProfesional, String nombre, String apellido, String correo,
			Date fechaCreacion, byte[] foto) {
		this.id = id;
		this.cedula = cedula;
		this.tarjetaProfesional = tarjetaProfesional;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaCreacion = fechaCreacion;
		this.foto = foto;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] imagen) {
		this.foto = imagen;
	}

	public Integer getFotoHashCode() {
		return (foto != null) ? foto.hashCode() : null;
	}

}
