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
import model.Zaposlen;
import repository.ZaposleniRepository;

@Path("/zaposleni")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZaposleniResource {

	@Inject
	ZaposleniRepository zaposleniRepository;
	
	@POST
	@Path("/addZaposleni")
	public Response addZaposleni(Zaposlen z) {
		Zaposlen zaposleni = zaposleniRepository.addZaposlen(z);
		return Response.ok().entity(zaposleni).build();
	}
	
	
	@GET
	@Path("/getAll")
	public List<Zaposlen> getAll(){
		return zaposleniRepository.getAll();
	}
}
