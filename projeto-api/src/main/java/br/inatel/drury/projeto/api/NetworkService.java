package br.inatel.drury.projeto.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/poller")
public interface NetworkService {

	@GET
	@Path("/start/{ip}/{mask}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Equipment> getListEquipment(@PathParam("ip") String ip , @PathParam("mask") String mask);
	
	@GET
	@Path("/status/{ip}")
	@Produces(MediaType.APPLICATION_JSON)
	Equipment getIpStatus(@PathParam("ip") String ip);
	
}
