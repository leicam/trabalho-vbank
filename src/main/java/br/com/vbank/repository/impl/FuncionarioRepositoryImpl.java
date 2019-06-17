package br.com.vbank.repository.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.com.vbank.domain.Agencia;
import br.com.vbank.domain.Funcionario;
import br.com.vbank.exception.AgenciaDesconhecidaException;
import br.com.vbank.repository.AgenciaRepository;
import br.com.vbank.repository.FuncionarioRepository;

@Stateless
public class FuncionarioRepositoryImpl extends AbstractRepositoryImpl<Funcionario> implements FuncionarioRepository {
	
	@Inject
	private AgenciaRepository agenciaRepository;

	public FuncionarioRepositoryImpl() {
		super(Funcionario.class);
	}

	@Override
	public boolean findFuncionarioAtivoByPessoaId(Long pessoaId) {
		String query = "select case when (count(f) > 0) then true else false end from Funcionario f where pessoa_id = :pPessoaId and status = ATIVO";
		TypedQuery<Boolean> tq = em.createQuery(query, Boolean.class);
		tq.setParameter("pPessoaId", pessoaId);
		return tq.getSingleResult();
	}
	
	@Override
	public Funcionario save(Funcionario funcionario) {
		if(funcionario.getAgencia()!=null) {
			Agencia agencia = agenciaRepository.findById(funcionario.getAgencia().getId());
			if(agencia ==null) {
				throw new AgenciaDesconhecidaException();
			}
		}
		return super.save(funcionario);
	}
	
	

}
