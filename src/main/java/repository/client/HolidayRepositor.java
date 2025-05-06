package repository.client;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.client.Holiday;
import model.client.HolidayType;
import model.client.PublicHolidayResponse;
import restclient.NagerDateClient;

@Dependent
public class HolidayRepositor {

	@Inject
	EntityManager em;
	
	@Inject
	@RestClient
	NagerDateClient NagerClient;
	

	@Transactional
	
	public List<Holiday> saveHoliday(String countryCode){
		 List<PublicHolidayResponse> holidays = NagerClient.getNextPublicHolidays(countryCode);
		    List<Holiday> savedHolidays = new ArrayList<>();

		    for (PublicHolidayResponse publicHolidayResponse : holidays) {
		        LocalDate holidayDate = publicHolidayResponse.getDate();

		        boolean exists = !em.createQuery(
		                "SELECT h FROM Holiday h WHERE h.date = :date AND h.countryCode = :countryCode").setParameter("date", holidayDate).setParameter("countryCode", publicHolidayResponse.getCountryCode()).getResultList().isEmpty();

		        if (exists) {
		            continue;
		        }

		        Holiday holi = new Holiday();
		        holi.setDate(holidayDate);
		        holi.setLocalName(publicHolidayResponse.getLocalName());
		        holi.setName(publicHolidayResponse.getName());
		        holi.setCountryCode(publicHolidayResponse.getCountryCode());

		        HolidayType type = new HolidayType();
		        type.setType(publicHolidayResponse.getType());
		        type.setHoliday(holi);  

		        holi.setTypes(Collections.singletonList(type)); 

		        em.persist(holi);  
		        em.persist(type); 

		        savedHolidays.add(holi);
		    }

		    return savedHolidays;
	}
	
	
	
	
	
	
	  @Transactional
	    public List<Holiday> getAll() {
	        return em.createQuery("SELECT h FROM Holiday h", Holiday.class).getResultList();
	    }
	
	
}


