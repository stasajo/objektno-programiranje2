package resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jboss.resteasy.reactive.MultipartForm;

import exception.KnjigaException;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.FileUploadForm;
import model.Knjiga;
import model.client.KnjigaKategorija;
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
	
	
	
	@GET 
	@Path("getKnjigeByName")
	public Response getKnjigeByName(@QueryParam(value = "name") String name) {
		
		List<Knjiga> knjige;
		
		try {
			knjige = knjigaRepository.getKnjigeByName(name);
		} catch (KnjigaException e) {
			// TODO: handle exception
			return Response.ok().entity(e.getMessage()).build();
		}
		return Response.ok().entity(knjige).build();
	}
	
	
	@POST
	@Path("createKnjigaKategorija")
	public Response addKnjigaKategorija(KnjigaKategorija kk) {
		KnjigaKategorija knjigakategorija = knjigaRepository.createKnjigaKategorija(kk);
		
		return Response.ok().entity(knjigakategorija).build();
	}
	
	
	
	@POST
	@Path("/uploadFile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	
	public Response uploadFile(@QueryParam("id") Long id, @MultipartForm FileUploadForm form) {
		
		Knjiga knjiga = knjigaRepository.findById(id);
		if(knjiga == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Knjiga nije pronadjena.").build();
		}
		
		
		
		String upload = "uploads";
		File dir = new File(upload);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		
		File file = new File(dir, form.fileName);
		try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(form.file);
        } catch (IOException e) {
            return Response.serverError().entity("Greška prilikom snimanja fajla").build();
        }
		
		
		
		
		knjiga.setFilePath(file.getAbsolutePath());
		
		knjigaRepository.addKnjiga(knjiga);
		return Response.ok(knjiga).build();
		
	}
	
	
	@GET
	@Path("/getById")
	public Response getKnjigaById(@QueryParam("id") Long id) {
		Knjiga knjiga = knjigaRepository.findById(id);
		if(knjiga == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		
		if(knjiga.getFilePath() != null) {
			 try {
	                byte[] fileContent = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(knjiga.getFilePath()));
	                knjiga.setFileDate(fileContent);
	            } catch (IOException e) {
	                return Response.serverError().entity("Greška pri čitanju fajla").build();
	            }
		}
		
		return Response.ok(knjiga).build();
	}
	
	
	
	
	
}
