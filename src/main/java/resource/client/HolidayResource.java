package resource.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import model.client.CountryResponse;
import model.client.PublicHolidayResponse;
import restclient.NagerDateClient;

@Path("/api/test")
public class HolidayResource {
	
		
	@Inject
	@RestClient
	NagerDateClient nagerDateClient;
	
	@GET
	@Path("/countries")
	public List<CountryResponse> getCountries(){
		return nagerDateClient.getAvailableCountries();
	}
	
	@GET
	@Path("/next/{countryCode}")
	public List<PublicHolidayResponse> getNextPublicHolideys(@PathParam("countryCode") String countryCode){
		return nagerDateClient.getNextPublicHolidays(countryCode);
	}
	
	
	

}
