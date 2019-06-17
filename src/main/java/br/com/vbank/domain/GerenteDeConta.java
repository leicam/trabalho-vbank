package br.com.vbank.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GC")
public class GerenteDeConta extends Gerente {

//	@ManyToOne
//	private Funcionario funcionario;

//	@Inject
//	private GerenteDeContaService gerenteDeContaServ;
	
	public GerenteDeConta() {
		
	}

//	public GerenteDeConta(Funcionario funcionario, Agencia agencia) {
//		super(funcionario.getPessoa(), agencia, CargoFuncionario.GERENTE_CONTA, funcionario.getSalario());
////		funcionarioRepo.save(this);
//	}

//	public void aceitaPropostaAberturaDeConta(Integer numeroDaProposta) {
//		gerenteDeContaServ.aceitaPropostaAberturaDeConta(numeroDaProposta, this);
//	}

	public void aceitarProposta(PropostaAberturaDeConta proposta) {
		proposta.aceitarProposta();
	}

}
