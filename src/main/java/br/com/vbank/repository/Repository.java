package br.com.vbank.repository;

import java.util.List;

import br.com.vbank.domain.BaseEntity;

public interface Repository<T extends BaseEntity> {

	List<T> getAll();

	T findById(Long id);

	T save(T object);

	void remove(Long id);

}
