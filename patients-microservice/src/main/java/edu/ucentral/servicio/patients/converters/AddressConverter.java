package edu.ucentral.servicio.patients.converters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import edu.ucentral.commons.patients.model.Address;
import edu.ucentral.commons.service.converter.dto.AbstractConverter;
import edu.ucentral.servicio.patients.dto.AddressDto;

public class AddressConverter extends AbstractConverter<Address, AddressDto> {

	@Autowired
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Address convertToEntity(AddressDto dto) {
		Address address = modelMapper.map(dto, Address.class);
		return address;
	}

	@Override
	public AddressDto convertToDto(Address entity) {
		AddressDto addressDto = modelMapper.map(entity, AddressDto.class);
		addressDto.setPostalCode(entity.getZipCode());
		return addressDto;
	}

	@Override
	public List<Address> listConvertToEntity(List<AddressDto> dtos) {
		return super.listConvertToEntity(dtos);
	}

	@Override
	public List<AddressDto> listConvertToDto(List<Address> entities) {
		return super.listConvertToDto(entities);
	}

}
