package model.client;

public class WeatherResponse {


	    private String temperature;
	    private String wind;
	    private String description;
	    
	    
		public WeatherResponse() {
			super();
		}


		public WeatherResponse(String temperature, String wind, String description) {
			super();
			this.temperature = temperature;
			this.wind = wind;
			this.description = description;
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
			return "WeatherResponse [temperature=" + temperature + ", wind=" + wind + ", description=" + description
					+ "]";
		}
	    
		
		
	    
	
}
