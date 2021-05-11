package edu.ucentral.servicio.beds.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "units")
public class Unit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String acronimo;
	private String tipo;// tipo servicio
	
	@NotNull
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beds == null) ? 0 : beds.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((acronimo == null) ? 0 : acronimo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		if (beds == null) {
			if (other.beds != null)
				return false;
		} else if (!beds.equals(other.beds))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (acronimo == null) {
			if (other.acronimo != null)
				return false;
		} else if (!acronimo.equals(other.acronimo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
