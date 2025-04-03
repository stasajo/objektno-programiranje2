package resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Knjiga;
import repository.KnjigaRepository;


@Path("/knjiga")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KnjigaResource {

	@Inject
	KnjigaRepository knjigaRepository;
	
	
	@POST
	@Path("/addKnjiga")

	public Response addKnjiga(Knjiga k) {
		Knjiga knjiga = knjigaRepository.addKnjiga(k);
		return Response.ok().entity(knjiga).build();
		
	}
	
	
	@GET
	@Path("/getAllKnjige")
	
	public Response getAllKnjige() {
		List<Knjiga> knjige = knjigaRepository.getAllKnjige();
		return Response.ok().entity(knjige).build();
	}
	
	
}
