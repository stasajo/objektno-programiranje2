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
import model.Iznajmljivanje;
import repository.IznajmljivanjeRepository;


@Path("/iznajmljivanje")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IznajmljivanjeResource {
	
		@Inject
		IznajmljivanjeRepository iznajmljivanjeRepository;
		
		@POST 
		@Path("/addIznajmljivanje")
		public Response addIznajmljivanje(Iznajmljivanje i) {
			Iznajmljivanje iznajmlj = iznajmljivanjeRepository.addIznajmljivanje(i);
			return Response.ok().entity(iznajmlj).build();
			
		}
		
		@GET
		@Path("/getAllIznajmljivanja")
		public Response getAllIznajmljivanja(){
			List<Iznajmljivanje> iznajmlj = iznajmljivanjeRepository.getAllIznajmljivanja();
			return Response.ok().entity(iznajmlj).build();
		}
		

}
