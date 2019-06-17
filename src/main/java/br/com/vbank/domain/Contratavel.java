package br.com.vbank.domain;

public interface Contratavel<T> {
	T create(Funcionario funcionario, Agencia agencia);

}
