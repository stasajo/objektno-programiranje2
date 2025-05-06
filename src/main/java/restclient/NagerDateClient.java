package restclient;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import model.client.CountryResponse;
import model.client.PublicHolidayResponse;


@RegisterRestClient(configKey = "nager-api")
public interface NagerDateClient {
	
	@GET
	@Path("/AvailableCountries")
	List<CountryResponse> getAvailableCountries();
	
	
	@GET
	@Path("NextPublicHolidays/{countryCode}")
	List<PublicHolidayResponse> getNextPublicHolidays(@PathParam("countryCode") String countryCode);
	

}
