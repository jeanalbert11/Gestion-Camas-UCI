package edu.ucentral.proyecto.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ips")
public class Ips implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nit;
	private String nombre;
	private String razonSocial;
	private String direccion;
	// esto seria otra clase

	private String localidad;

	public Ips(Long id, String nit, String nombre, String razonSocial, String direccion, String localidad,
			List<Cama> camas) {
		super();
		this.id = id;
		this.nit = nit;
		this.nombre = nombre;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.localidad = localidad;
		this.camas = camas;
	}

	@OneToMany(fetch = FetchType.LAZY)
	private List<Cama> camas;
	
/*
	public Ips() {
		this.camas = camas;
	}
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Cama> getCamas() {
		return camas;
	}

	public void setCamas(List<Cama> camas) {
		this.camas = camas;
	}

	public void addCama(Cama cama) {
		this.camas.add(cama);
	}

	public void revomeCama(Cama cama) {
		camas.remove(cama);
	}

}