package br.com.vbank.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.vbank.enumerator.UF;

public class EnderecoCEP {
	
	@Id
	private Long cep;
	private String logradouro;	
	private String complemento;
	private String bairro;
	private String localidade;
	
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	private Integer unidade;
	private Integer ibge;
	private Integer gia;
	
	public UF nomeUFToEnumUF(String nomeUF) {
		return UF.stream().filter(uf -> uf.name().equals(nomeUF)).findAny().get();
	}

	public Long getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public UF getUf() {
		return uf;
	}

	public Integer getUnidade() {
		return unidade;
	}

	public Integer getIbge() {
		return ibge;
	}

	public Integer getGia() {
		return gia;
	}
	

}
