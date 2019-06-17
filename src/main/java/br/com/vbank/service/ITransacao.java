package br.com.vbank.service;

public interface ITransacao {
	void transferir();
	void agendarTransferencia();
	void pagarConta();
	void agendarPagamentoConta();
}
