package resource.client;

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
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.client.Weather;
import model.client.WeatherResponse;
import repository.client.WeatherRepository;
import restclient.WeatherClient;

@Path("/weather2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WeatherBaseResource {
	
    @Inject
    WeatherRepository weatherRepository;

    @Inject
    @RestClient
    WeatherClient weatherClient;

    @POST
    @Path("/fetch/{city}")
    @Transactional
    public Response postWeather(@PathParam("city") String city) {
        WeatherResponse response = weatherClient.getWeather(city);
        Weather savedWeather = weatherRepository.saveWeather(city, response);
        return Response.ok(savedWeather).build();
    }

    @GET
    public Response getAll() {
        List<Weather> allWeather = weatherRepository.getAll();
        return Response.ok(allWeather).build();
    }
}





