package br.com.vbank.repository;

import java.util.List;

import br.com.vbank.domain.Pessoa;

public interface PessoaRepository extends Repository<Pessoa> {

	boolean findCPF(Integer cpf);

	Pessoa findByCPF(Integer cpf);

	List<Pessoa> findByNome(String nome);

}
