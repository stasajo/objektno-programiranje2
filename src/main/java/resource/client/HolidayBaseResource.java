package resource.client;

import java.util.Iterator;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Knjiga;
import model.client.Holiday;
import model.client.PublicHolidayResponse;
import repository.client.HolidayRepositor;
import restclient.NagerDateClient;

@Path("/holidays")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HolidayBaseResource {
	
	@Inject
	HolidayRepositor holidayRepository;
	
	
	@Inject
	@RestClient
	NagerDateClient nagerClient;
	
	@POST
	@Path("/fetch/{countryCode}")
	@Transactional
	public Response fetchAndSave(@PathParam("countryCode") String countryCode) {
		List<PublicHolidayResponse> holidays = nagerClient.getNextPublicHolidays(countryCode);
		
		
		for (PublicHolidayResponse publicHolidayResponse : holidays) {
			holidayRepository.saveHoliday(countryCode);
		}
		
		
		
		return Response.ok(holidays).build();
	}
		
	
	@GET
	public Response getAll(){
		List<Holiday> holiday = holidayRepository.getAll();
		return  Response.ok().entity(holiday).build();
		
	}
	
	

}
