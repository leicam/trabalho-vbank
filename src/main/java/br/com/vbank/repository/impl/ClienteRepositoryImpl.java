package br.com.vbank.repository.impl;

import javax.persistence.TypedQuery;

import br.com.vbank.domain.Cliente;
import br.com.vbank.repository.ClienteRepository;

public class ClienteRepositoryImpl extends AbstractRepositoryImpl<Cliente> implements ClienteRepository {

	public ClienteRepositoryImpl() {
		super(Cliente.class);
	}

	@Override
	public Cliente findByPessoaId(Long pessoaId) {
		String query = "select c from Cliente c where pessoaId = :pPessoaId";
		TypedQuery<Cliente> tq = em.createQuery(query, Cliente.class);
		tq.setParameter("pPessoaId", pessoaId);
		return tq.getSingleResult();
	}

}
