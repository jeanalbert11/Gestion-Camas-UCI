package edu.ucentral.servicio.patients.dto;

import java.io.Serializable;

public class AddressDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String postalCode;
	private String address;

	public AddressDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
