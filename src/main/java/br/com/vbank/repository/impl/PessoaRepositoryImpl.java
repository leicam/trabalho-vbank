package br.com.vbank.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.vbank.domain.Pessoa;
import br.com.vbank.repository.PessoaRepository;

public class PessoaRepositoryImpl extends AbstractRepositoryImpl<Pessoa> implements PessoaRepository {

	public PessoaRepositoryImpl() {
		super(Pessoa.class);
	}

	@Override
	public boolean findCPF(Integer cpf) {
		String query = "select case when (count(p) > 0) then true else false end from Pessoa p where cpf = :pCPF";
		TypedQuery<Boolean> tq = em.createQuery(query, Boolean.class);
		tq.setParameter("pCPF", cpf);
		return tq.getSingleResult();
	}

	@Override
	public Pessoa findByCPF(Integer cpf) {
		String query = "select p from Pessoa where cpf = :pCPF";
		TypedQuery<Pessoa> tq = em.createQuery(query, Pessoa.class);
		tq.setParameter("pCPF", cpf);
		return tq.getSingleResult();
	}

	@Override
	public List<Pessoa> findByNome(String nome) {
		TypedQuery<Pessoa> tq = em.createQuery("select p from Pessoa p where nome like :pNome", Pessoa.class);
		tq.setParameter("pNome", nome + "%");
		return tq.getResultList();
	}

}
