package br.com.vbank.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.vbank.domain.TransferenciaDoc;
import br.com.vbank.domain.TransferenciaTed;
import br.com.vbank.service.TransferenciaService;

@Path("transferencia")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransferenciaController {
	
	@Inject
	private TransferenciaService transferenciaService;
	
	@POST
	@Path("ted")
	public Response transferenciaTed(TransferenciaTed transferenciaTed) {
		return Response.ok(transferenciaService.ted(transferenciaTed)).build();
	}
	
	@POST
	@Path("doc")
	public Response transferenciaTed(TransferenciaDoc transferenciaDoc) {
		return Response.ok(transferenciaService.doc(transferenciaDoc)).build();
	}

}
