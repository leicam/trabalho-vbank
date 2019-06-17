package br.com.vbank.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.vbank.domain.Funcionario;
import br.com.vbank.service.AgenciaService;

@Path("agencia")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AgenciaController {

	@Inject
	private AgenciaService agenciaService;

//	@POST
//	@Path("registra-funcionario")
//	public Response registraFuncionario(Funcionario funcionario) {
////		Funcionario funcionario = new Gson().fromJson(conteudo, Funcionario.class);
////		Long funcionarioId = agenciaService.registraFuncionario(funcionario, funcionario.getAgencia().getId());
////		return Response.ok(funcionarioId).build();
//
////		return Response
////				.created(URI.create("/funcionarios/"
////						+ agenciaServ.registraFuncionario(new Gson().fromJson(conteudo, Funcionario.class), agenciaId)))
////				.build();
//		
//		agenciaService.
//		
//	}

	@POST
	@Path("{agencia}/registra-funcionario")
	public Response registraFuncionario(@PathParam("agencia") Long agencia, 
			Funcionario funcionario) {
		return Response.ok(agenciaService.registraFuncionario(agencia, funcionario)).build();
//		Funcionario funcionario = new Gson().fromJson(conteudo, Funcionario.class);
//		Long funcionarioId = agenciaService.registraFuncionario(funcionario, funcionario.getAgencia().getId());
//		return Response.ok(funcionarioId).build();

//		return Response
//				.created(URI.create("/funcionarios/"
//						+ agenciaServ.registraFuncionario(new Gson().fromJson(conteudo, Funcionario.class), agenciaId)))
//				.build();
	}

}
