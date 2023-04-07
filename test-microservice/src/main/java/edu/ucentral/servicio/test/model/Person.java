package edu.ucentral.servicio.test.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import edu.ucentral.servicio.test.model.Person;

@Entity
@Table(name = "test")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "empty field")
	@Size(min = 3, max = 20, message = "the number of character must be between 3 and 20")
	private String nombre;

	@NotEmpty(message = "empty field")
	@Size(min = 3, max = 20, message = "the number of character must be between 3 and 20")
	private String apellido;

	@NotEmpty(message = "empty field")
	@Size(min = 3, max = 8, message = "the number of character must be between 3 and 10")
	private String celular;

	public Person() {

	}

	public Person(Long id, String nombre, String apellido, String celular) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
