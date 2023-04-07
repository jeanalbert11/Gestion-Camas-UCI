package edu.ucentral.servicio.patients.dto;

import java.io.Serializable;

public class PatientDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String fullname;

//	private String postalCode;

	private AddressDto address;

//	private List<AddressDto> addressDtos;

	public PatientDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

//	public String getPostalCode() {
//		return postalCode;
//	}
//
//	public void setPostalCode(String postalCode) {
//		this.postalCode = postalCode;
//	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

//	public List<AddressDto> getAddressDtos() {
//		return addressDtos;
//	}
//
//	public void setAddressDtos(List<AddressDto> addressDtos) {
//		this.addressDtos = addressDtos;
//	}

}
