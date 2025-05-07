package model.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Weather {
	@Id
	private String city;
	
	
    private String temperature;
    private String wind;
    private String description;
	
    
    public Weather() {
		super();
	}


	public Weather(String city, String temperature, String wind, String description) {
		super();
		this.city = city;
		this.temperature = temperature;
		this.wind = wind;
		this.description = description;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getTemperature() {
		return temperature;
	}


	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}


	public String getWind() {
		return wind;
	}


	public void setWind(String wind) {
		this.wind = wind;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Weather [city=" + city + ", temperature=" + temperature + ", wind=" + wind + ", description="
				+ description + "]";
	}
    
	
    
    
    
    

}
