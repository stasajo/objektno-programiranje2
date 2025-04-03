package resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Izdavac;
import repository.IzdavacRepository;

@Path("/izdavac")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class IzdavacResource {
	
	@Inject
	IzdavacRepository izdavacRepository;
	
	
	@POST
	public Response addIzdavac(Izdavac i) {
		izdavacRepository.addIzdavac(i);
		return Response.status(Response.Status.CREATED).build();
	}
	
	
	@GET
	public List<Izdavac> getAll(){
		return izdavacRepository.getAll();
	}
	
	
	

}
