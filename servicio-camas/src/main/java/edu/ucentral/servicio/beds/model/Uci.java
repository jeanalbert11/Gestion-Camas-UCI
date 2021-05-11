package edu.ucentral.servicio.beds.model;

import java.io.Serializable;

public class Uci implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;// tipo servicio

	/*
	 * @OneToMany(fetch = FetchType) private List<Bed> beds;
	 */
	/*
	 * private Hospital hospital;
	 */
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

}
