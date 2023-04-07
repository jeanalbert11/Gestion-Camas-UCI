package edu.ucentral.microservice.units.model;

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
import javax.validation.constraints.NotNull;
import edu.ucentral.commons.beds.model.Bed;

@Entity
@Table(name = "units")
public class Unit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String acronimo;
	private String tipo;// service type
	@ManyToOne
	private Service service;

	@NotNull
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Bed> beds;

	public Unit() {
		this.beds = new ArrayList<Bed>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String nombre) {
		this.acronimo = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String servico) {
		this.tipo = servico;
	}

	public List<Bed> getBeds() {
		return beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

	public void addBed(Bed bed) {
		beds.add(bed);
	}

	public void removeBed(Bed bed) {
		beds.remove(bed);

	}


}
