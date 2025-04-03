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
import model.Kategorija;
import repository.KategorijaRepository;

@Path("/kategorija")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class KategorijaResource {
	
	@Inject
	KategorijaRepository kategorijaRepository;
	
	
	@POST
	public Response addKategorija(Kategorija k) {
		kategorijaRepository.addKategorija(k);
		return Response.status(Response.Status.CREATED).build();
	}
	
	
	@GET
	public List<Kategorija> getAll(){
		return kategorijaRepository.getAll();
	}
	
	

}
