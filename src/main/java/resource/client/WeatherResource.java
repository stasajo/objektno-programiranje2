package resource.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import model.client.WeatherResponse;
import restclient.WeatherClient;

@Path("/weather")
public class WeatherResource {

	@Inject
	@RestClient
	WeatherClient weatherClient;
	
	@GET
	@Path("/getForecast/")
	public WeatherResponse getForecast(@QueryParam("city") String city){
		System.out.println("dkdmjsdknsd");
		return weatherClient.getWeather(city);
	}
	
}
