package br.com.vbank.enumerator;

public enum ConfigConta {
	PRAZO_ABERTURA_CONTA(30);
	
	private Integer valor;
	
	ConfigConta(Integer valor) {
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}
}
