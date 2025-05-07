package restclient;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import model.client.WeatherResponse;

@RegisterRestClient(configKey = "weather-api")
public interface WeatherClient {
	
	@GET
	@Path("weather/{city}")
	WeatherResponse getWeather(@PathParam("city") String city);
	
	

}
