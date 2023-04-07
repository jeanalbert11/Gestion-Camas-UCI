package edu.ucentral.servicio.patients.converters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ucentral.commons.patients.model.Address;
import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.converter.dto.AbstractConverter;
import edu.ucentral.servicio.patients.dto.AddressDto;
import edu.ucentral.servicio.patients.dto.PatientDto;

public class PatientConverter extends AbstractConverter<Patient, PatientDto> {

	@Autowired
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Patient convertToEntity(PatientDto dto) {
		Patient patient = modelMapper.map(dto, Patient.class);

		/* --------forma manual-------- */
//		Patient patient = new Patient();
//		// data from dto
//		patient.setId(dto.getId());
//		patient.setName(dto.getFullname());
//		patient.setSurname(dto.getFullname());

		/**
		 * if (dto.getAddressDtos() != null) { patient.setAddresses(new ArrayList<>());
		 * for (AddressDto addressDto : dto.getAddressDtos()) { AddressConverter
		 * addressConverter = new AddressConverter(); Address address = new Address();
		 * address.setId(addressDto.getId());
		 * address.setAddress(addressDto.getAddress());
		 * address.setZipCode(addressDto.getPostalCode());
		 * //address.setPatient(this.convertToEntity(addressDto.getPatientDto()));//this
		 * -> utiliza la referencia de la misma clase address.setPatient(patient);
		 * patient.getAddresses().add(address); } }
		 */

		return patient;
	}

	@Override
	public PatientDto convertToDto(Patient entity) {
		PatientDto patientDto = modelMapper.map(entity, PatientDto.class);
		/*--------forma manual-------- */
//		PatientDto patientDto = new PatientDto();
//		//data from entity
//		patientDto.setId(entity.getId());
		patientDto.setFullname(entity.getName() + " " + entity.getSurname());
//		patientDto.getAddress().setPostalCode(entity.getAddress().getZipCode());
//
		Address address = entity.getAddress();
		if (address != null) {
			AddressDto addressDto = new AddressDto();
			addressDto.setId(address.getId());
			addressDto.setPostalCode(address.getZipCode());
//			patientDto.setPostalCode(address.getZipCode());
			addressDto.setAddress(address.getAddress());
			patientDto.setAddress(addressDto);
		}

		/**
		 * ---- En caso que la entidad tuviese una lista asociada if
		 * (entity.getAddresses() != null) { patientDto.setAddressDtos(new
		 * ArrayList<>()); for (Address address : entity.getAddresses()) { AddressDto
		 * addressDto = new AddressDto(); addressDto.setId(address.getId());
		 * addressDto.setAddress(address.getAddress());
		 * addressDto.setPostalCode(address.getZipCode());
		 * //addressDto.setPatientDto(this.convertToDto(entity));
		 * patientDto.getAddressDtos().add(addressDto); } }
		 */

		return patientDto;
	}

	@Override
	public List<Patient> listConvertToEntity(List<PatientDto> dtos) {
		return super.listConvertToEntity(dtos);
	}

	@Override
	public List<PatientDto> listConvertToDto(List<Patient> entities) {
		return super.listConvertToDto(entities);
	}

}
