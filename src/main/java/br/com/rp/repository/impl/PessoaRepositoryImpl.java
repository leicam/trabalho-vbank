package br.com.rp.repository.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.rp.domain.Pessoa2;
import br.com.rp.repository.PessoaRepository;

@Stateless
public class PessoaRepositoryImpl extends AbstractRepositoryImpl<Pessoa2> implements PessoaRepository {

	public PessoaRepositoryImpl() {
		super(Pessoa2.class);
	}

	@Override
	public List<Pessoa2> findPessoaPorNome(String nome) {
		TypedQuery<Pessoa2> tq = em.createQuery("select p from Pessoa p where nome like :nome", Pessoa2.class);
		tq.setParameter("nome", nome + "%");
		return tq.getResultList();
	}

}
