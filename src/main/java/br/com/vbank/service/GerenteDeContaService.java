package br.com.vbank.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.vbank.domain.Cliente;
import br.com.vbank.domain.Conta;
import br.com.vbank.domain.Gerente;
import br.com.vbank.domain.Pessoa;
import br.com.vbank.domain.PropostaAberturaDeConta;
import br.com.vbank.enumerator.MotivoDecisaoPropostaAberturaDeConta;
import br.com.vbank.enumerator.SituacaoAberturaDeConta;
import br.com.vbank.enumerator.UF;
import br.com.vbank.repository.ClienteRepository;
import br.com.vbank.repository.PessoaRepository;
import br.com.vbank.repository.PropostaAberturaDeContaRepository;

@Stateless
public class GerenteDeContaService {

	@EJB
	private PropostaAberturaDeContaRepository propostaRepo;

	@EJB
	private ClienteRepository clienteRepo;

	@EJB
	private PessoaRepository pessoaRepo;

	public List<PropostaAberturaDeConta> vizualizaTodasPropostasRecebidas() {
		return propostaRepo.getAll();
	}

	public List<PropostaAberturaDeConta> vizualizaPropostasRecebidasPorRegiao(UF uf) {
		return propostaRepo.getAllBy(uf);
	}

	public List<PropostaAberturaDeConta> vizualizaPropostasRecebidasPorSituacao(SituacaoAberturaDeConta situacao) {
		return propostaRepo.getAllBy(situacao);
	}

	public List<PropostaAberturaDeConta> vizualizaPropostasRecebidasPorRegiaoEPorSituacao(UF uf,
			SituacaoAberturaDeConta situacao) {
		return propostaRepo.getAllBy(uf, situacao);
	}

	/*
	 * aceitar ou rejeitar propostas. No caso da aceitação da proposta, uma nova
	 * conta deve ser criada e enviado ao proponente um email com o número da
	 * conta, bem como o meio para o cadastramento da primeira senha de acesso ao
	 * sistema. No caso de rejeitá-lo, deve-se enviar um e-mail ao proponente,
	 * expondo o motivo pelo qual foi negada a sua proposta.
	 */

	//ver se vale a pena passar lista
	public void aceitaPropostaAberturaDeConta(Integer numeroDaProposta, Gerente gerente) {
		Long pessoaId = findPessoaIdByNumeroDaProposta(numeroDaProposta);
		Pessoa pessoa = pessoaRepo.findById(pessoaId);
		Cliente cliente = clienteRepo.findByPessoaId(pessoaId);

		Conta conta;
		if (cliente == null) cliente = new Cliente(pessoa, gerente.getAgencia(), conta = geraConta(pessoa, cliente, gerente));
		else conta = geraConta(pessoa, cliente, gerente);

		new AnunciadorService().enviarEmail(pessoaId, conta.getNumeroConta(), conta.getSenhaTemporaria());

		// falta validar se já possui o tipo de conta (cc/poup), casa já tenha lançar exception
	}

	private Conta geraConta(Pessoa pessoa, Cliente cliente, Gerente gerente) {
		return new Conta(pessoa, cliente, gerente);
	}

	public void rejeitaPropostaAberturaDeConta(Integer numeroDaProposta, MotivoDecisaoPropostaAberturaDeConta motivo) {
		Long pessoaId = findPessoaIdByNumeroDaProposta(numeroDaProposta);
		new AnunciadorService().enviarEmail(pessoaId, motivo);
	}

	private Long findPessoaIdByNumeroDaProposta(Integer numeroDaProposta) {
		return propostaRepo.findPessoaIdByNumeroDaProposta(numeroDaProposta);
	}

	// gerentes de contas, somente tem acesso a dados dos clientes, contas dos clientes, movimentações e propostas de cadastro.

}
