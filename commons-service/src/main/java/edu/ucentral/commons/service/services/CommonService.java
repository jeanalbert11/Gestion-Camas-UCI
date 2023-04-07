package edu.ucentral.commons.service.services;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

public interface CommonService<T> {

	public Iterable<T> findAll();

	public Optional<T> findById(Long id);

	public T save(T entity);

	public void deleteById(Long id);

	//to pagination
	public Iterable<T> findAll(Pageable pageable);

}
