package br.com.vbank.domain;

import javax.ejb.EJB;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.vbank.enumerator.UF;

public class Endereco {
	
	@OneToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "cep")
	private EnderecoCEP enderecoCEP;
	
	private String numeroLogradouro;
	
//	@EJB
//	private EnderecoCEPRepository enderecoCEPRepo;
	
	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}
	
	public String getLogradouro() {
		return enderecoCEP.getLogradouro();
	}
	
	public String getComplemento() {
		return enderecoCEP.getComplemento();
	}

	public String getBairro() {
		return enderecoCEP.getBairro();
	}

	public String getLocalidade() {
		return enderecoCEP.getLocalidade();
	}

	public UF getUf() {
		return enderecoCEP.getUf();
	}

	public Integer getUnidade() {
		return enderecoCEP.getUnidade();
	}

	public Integer getIbge() {
		return enderecoCEP.getIbge();
	}

	public Integer getGia() {
		return enderecoCEP.getGia();
	}

}
