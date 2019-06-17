package br.com.vbank.repository.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.vbank.domain.PropostaAberturaDeConta;
import br.com.vbank.enumerator.SituacaoAberturaDeConta;
import br.com.vbank.enumerator.UF;
import br.com.vbank.repository.PropostaAberturaDeContaRepository;

public class PropostaAberturaDeContaRepositoryImpl extends AbstractRepositoryImpl<PropostaAberturaDeConta> implements PropostaAberturaDeContaRepository {

	public PropostaAberturaDeContaRepositoryImpl() {
		super(PropostaAberturaDeConta.class);
	}

	@Override
	public List<PropostaAberturaDeConta> getAllBy(UF uf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropostaAberturaDeConta> getAllBy(SituacaoAberturaDeConta situacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropostaAberturaDeConta> getAllBy(UF uf, SituacaoAberturaDeConta situacao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean possuiPropostaEmSituacao(SituacaoAberturaDeConta situacao, Long pessoaId) {
		String query = "select case when (count(p) > 0) then true else false end from proposta_abertura_conta p"
				+ " where pessoaId = :pPessoaId and situacaoAberturaDeConta = :pSituacao";
		TypedQuery<Boolean> tq = em.createQuery(query, Boolean.class);
		tq.setParameter("pPessoaId", pessoaId);
		tq.setParameter("pSituacao", situacao.name());
		return tq.getSingleResult();
	}

	@Override
	public Long findPessoaIdByNumeroDaProposta(Integer numeroDaProposta) {
		String query = "select pessoa_id from proposta_abertura_conta where numero_proposta = :pNumeroDaProposta";
		TypedQuery<Long> tq = em.createQuery(query, Long.class);
		tq.setParameter("pNumeroDaProposta", numeroDaProposta);
		return tq.getSingleResult();
	}

	@Override
	public void removeTodasPropostasForaDoPrazo(Integer prazo) {
		LocalDate data = LocalDate.now().minusDays(prazo);
		Query query = em.createQuery("delete p from proposta_abertura_conta where data_solicitacao < :pData");
		query.setParameter("pData", data);
		query.executeUpdate();
	}

}
