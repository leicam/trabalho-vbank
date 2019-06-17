package br.com.vbank.repository.impl;

import java.util.List;

import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vbank.domain.BaseEntity;
import br.com.vbank.repository.Repository;
import br.com.vbank.repository.impl.LogInterceptor;

@Interceptors(LogInterceptor.class)
public abstract class AbstractRepositoryImpl<T extends BaseEntity> implements Repository<T> {

	@PersistenceContext(unitName = "vbankpu")
	protected EntityManager em;

	private Class<T> clazz;

	public AbstractRepositoryImpl(Class<T> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Clazz is mandatory");
		}
		this.clazz = clazz;
	}

	@Override
	public List<T> getAll() {
		return em.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
	}

	@Override
	public T findById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("id is mandatory");
		}
		return em.find(clazz, id);
	}

	@Override
	public T save(T object) {
		if (object instanceof BaseEntity) {
			BaseEntity entity = (BaseEntity) object;
			if (entity.getId() != null) {
				return em.merge(object);
			} else {
				em.persist(object);
				return object;
			}
		} else
			throw new IllegalArgumentException("Entity is not a BaseEntity");
	}

	@Override
	public void remove(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("id is mandatory");
		}
		T obj = findById(id);
		if (obj != null) {
			em.remove(obj);
		} else
			throw new IllegalArgumentException("id not found for removing");
	}

}
