package br.com.vbank.enumerator;

import java.util.stream.Stream;

public enum UF {
	PR("Paraná"), SP("São Paulo");
	
	private String nomeUF;
	
	private UF(String nomeUF) {
		this.nomeUF = nomeUF;
	}
	
	public static Stream<UF> stream() {
		return Stream.of(UF.values());
	}

}
