package br.com.vbank.repository;

import br.com.vbank.domain.TransferenciaInterna;

public interface TransferenciaInternaRepository extends Repository<TransferenciaInterna>{
	boolean transferir(TransferenciaInterna transferencia);
}
