package resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Clan;
import repository.ClanRepository;

@Path("/clan")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ClanResource {
	
	@Inject
	ClanRepository clanRepository;
	
	@POST 
	public Response addClan(Clan clan) {
		clanRepository.addClan(clan);
		return Response.status(Response.Status.CREATED).build();
		
	}
	
	@GET
	public List<Clan> getAll(){
		return clanRepository.getAll();
	}
	

}
