package edu.ucentral.commons.service.converter.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E, D> {

	public abstract E convertToEntity(D dto);

	public abstract D convertToDto(E entity);

	public List<E> listConvertToEntity(List<D> dtos) {
		if (dtos == null) {
			return Collections.emptyList();
		}
		return dtos.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
	}

	public List<D> listConvertToDto(List<E> entities) {
		if (entities == null) {
			return Collections.emptyList();
		}
		return entities.stream().map(entity -> convertToDto(entity)).collect(Collectors.toList());
	}
}
