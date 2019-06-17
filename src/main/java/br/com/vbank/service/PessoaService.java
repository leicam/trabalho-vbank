package br.com.vbank.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.vbank.domain.Pessoa;
import br.com.vbank.domain.PropostaAberturaDeConta;
import br.com.vbank.enumerator.UF;
import br.com.vbank.exception.PessoaNaoPossuiCadastroException;
import br.com.vbank.repository.PessoaRepository;

@Stateless
public class PessoaService {
	
	@EJB
	PessoaRepository pessoaRepo;
	
	public void realizaCadastro(String nome, Integer cpf, Integer cep, String numeroLogradouro) {
		pessoaRepo.save(new Pessoa(nome, cpf, cep, numeroLogradouro));
	}
	
	public Pessoa localizaCadastro(Integer cpf) {
		return pessoaRepo.findByCPF(cpf);
	}
	
	public List<Pessoa> localizaCadastro(String nome) {
		return pessoaRepo.findByNome(nome);
	}
	
	public void alteraCadastro(Pessoa pessoa) {
		Pessoa pessoaEncontrada = pessoaRepo.findByCPF(pessoa.getCPF());
		pessoa.setId(pessoaEncontrada.getId());
		pessoaRepo.save(pessoa);
	}
	
	public void solicitaAberturaDeConta(Integer cpf, UF uf) {
		new PropostaAberturaDeConta(findPessoaByCPF(cpf), uf);
	}
	
	public Pessoa findPessoaByCPF(Integer cpf) {
		Pessoa pessoa = pessoaRepo.findByCPF(cpf);
		if(pessoa == null) throw new PessoaNaoPossuiCadastroException();
		return pessoa;
	}

}
