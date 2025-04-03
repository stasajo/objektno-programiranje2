package resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import model.Autor;
import repository.AutorRepository;



@Path("/autor")
public class AutorResource {
	
	@Inject
	AutorRepository autorRepository;
	
	@POST 
	public Response addAutor(Autor a) {
		autorRepository.addAutor(a);
		return Response.status(Response.Status.CREATED).build();
		
	}
	
	@GET
	public List<Autor> getAll(){
		return autorRepository.getAll();
	}
	

}
