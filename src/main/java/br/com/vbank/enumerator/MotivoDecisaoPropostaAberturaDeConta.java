package br.com.vbank.enumerator;

public enum MotivoDecisaoPropostaAberturaDeConta {
	INADIMPLENTE("Cliente encontras-se inadimplente"), 
	INADEQUADO("Cliente não atende aos requisitos adequados do banco.");
	
	private String mensagemMotivo;
	
	private MotivoDecisaoPropostaAberturaDeConta(String mensagemMotivo) {
		this.mensagemMotivo = mensagemMotivo;
	}
	
	public String getMotivo() {
		return mensagemMotivo;
	}
}
