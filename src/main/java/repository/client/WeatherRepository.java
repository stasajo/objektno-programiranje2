package repository.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.client.Holiday;
import model.client.Weather;
import model.client.WeatherResponse;
import restclient.WeatherClient;

@Dependent
public class WeatherRepository {

	@Inject
	EntityManager em;
	
	@Inject
	@RestClient
	WeatherClient weatherClient;
	
	 @Transactional
	    public Weather saveWeather(String city, WeatherResponse response) {
	        city = city.trim();

	        boolean exists = !em.createQuery("SELECT w FROM Weather w WHERE w.city = :city").setParameter("city", city).getResultList().isEmpty();

	        if (exists) {
	        	return em.find(Weather.class, city);
	        }

	        Weather weather = new Weather();
	        weather.setCity(city);
	        weather.setTemperature(response.getTemperature());
	        weather.setWind(response.getWind());
	        weather.setDescription(response.getDescription());

	        em.persist(weather);

	        return weather;
	    }

	    @Transactional
	    public Weather getWeatherByCity(String city) {
	        return em.find(Weather.class, city);
	    }
	    
	    @Transactional
	    public List<Weather> getAll() {
	        return em.createQuery("SELECT w FROM Weather w", Weather.class).getResultList();
	    }
	
	
}
