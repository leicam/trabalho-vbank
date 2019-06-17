package br.com.vbank.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.vbank.domain.Agencia;
import br.com.vbank.domain.Funcionario;
import br.com.vbank.exception.AgenciaDesconhecidaException;
import br.com.vbank.repository.AgenciaRepository;

@Stateless
public class AgenciaService {

//	@Inject
//	Agencia agencia;

	@Inject
	private AgenciaRepository agenciaRepository;

	public Long registraFuncionario(Long agenciaId, Funcionario funcionario) {
		Agencia agencia = agenciaRepository.findById(agenciaId);
		if (agencia == null) {
			throw new AgenciaDesconhecidaException();
		}
		agencia.adicionaFuncionario(funcionario);
		agenciaRepository.save(agencia);
		return funcionario.getId();
		
	}

//	public 

}
