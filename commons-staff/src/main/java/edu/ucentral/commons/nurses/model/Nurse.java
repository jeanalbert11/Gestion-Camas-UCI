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

	@NotEmpty(message = "empty field")
	@Column(name = "identity_card")
	private String identityCard;

	@NotEmpty(message = "empty field")
	@Column(name = "professional_card")
	private String professionalCard;

	@NotEmpty(message = "empty field")
	@Size(min = 3, max = 20, message = "the number of character must be between 3 and 20")
	private String name;

	@NotEmpty(message = "empty field")
	@Size(min = 3, max = 20, message = "the number of character must be between 3 and 20")
	private String surname;

	@NotEmpty(message = "empty field")
	@Email(message = "It's not a valid email address")
	private String email;

	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@Lob
	@JsonIgnore
	private byte[] foto;

	public Nurse() {
	}

	public Nurse(Long id, String identityCard, String professionalCard, String name, String surname, String email,
			Date creationDate, byte[] foto) {

		this.id = id;
		this.identityCard = identityCard;
		this.professionalCard = professionalCard;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.creationDate = creationDate;
		this.foto = foto;
	}

	@PrePersist
	void prePersist() {
		creationDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getProfessionalCard() {
		return professionalCard;
	}

	public void setProfessionalCard(String professionalCard) {
		this.professionalCard = professionalCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Integer getFotoHashCode() {
		return (foto != null) ? foto.hashCode() : null;
	}

}
