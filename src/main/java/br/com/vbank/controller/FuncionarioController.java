package br.com.vbank.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.vbank.domain.Funcionario;
import br.com.vbank.repository.FuncionarioRepository;

@Path("funcionario")
@Consumes("application/json")
@Produces("application/json")
public class FuncionarioController {

	@Inject
	private FuncionarioRepository repository;

	@POST
	public Response save(Funcionario funcionario) {
		return Response.ok(repository.save(funcionario)).build();
	}

}
