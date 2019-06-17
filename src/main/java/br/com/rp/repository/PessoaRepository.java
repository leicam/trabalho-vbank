package br.com.rp.repository;

import java.util.List;

import br.com.rp.domain.Pessoa2;

public interface PessoaRepository extends Repository<Pessoa2> {
	
	List<Pessoa2> findPessoaPorNome(String nome);

}
