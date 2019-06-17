package br.com.vbank.repository;

import java.util.List;

import br.com.vbank.domain.PropostaAberturaDeConta;
import br.com.vbank.enumerator.SituacaoAberturaDeConta;
import br.com.vbank.enumerator.UF;

public interface PropostaAberturaDeContaRepository extends Repository<PropostaAberturaDeConta> {

	List<PropostaAberturaDeConta> getAllBy(UF uf);
	
	List<PropostaAberturaDeConta> getAllBy(SituacaoAberturaDeConta situacao);
	
	List<PropostaAberturaDeConta> getAllBy(UF uf, SituacaoAberturaDeConta situacao);

	boolean possuiPropostaEmSituacao(SituacaoAberturaDeConta situacaoAberturaDeConta, Long pessoaId);

	Long findPessoaIdByNumeroDaProposta(Integer numeroDaProposta);

	void removeTodasPropostasForaDoPrazo(Integer prazo);

}
