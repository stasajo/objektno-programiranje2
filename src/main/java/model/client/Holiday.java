package model.client;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Holiday {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

    private LocalDate date;
    private String localName;
    private String name;
    private String countryCode;
    private boolean fixed;
    private boolean global;
	private int launchYear;
	
	
	@OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HolidayType> types;
	
	
	public Holiday() {
		super();
	}

	public Holiday(long id, LocalDate date, String localName, String name, String countryCode, boolean fixed,
			boolean global, int launchYear) {
		super();
		this.id = id;
		this.date = date;
		this.localName = localName;
		this.name = name;
		this.countryCode = countryCode;
		this.fixed = fixed;
		this.global = global;
		this.launchYear = launchYear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public boolean isGlobal() {
		return global;
	}

	public void setGlobal(boolean global) {
		this.global = global;
	}

	public int getLaunchYear() {
		return launchYear;
	}

	public void setLaunchYear(int launchYear) {
		this.launchYear = launchYear;
	}

	public List<HolidayType> getTypes() {
		return types;
	}

	public void setTypes(List<HolidayType> types) {
		this.types =  types;
	}

	@Override
	public String toString() {
		return "Holiday [id=" + id + ", date=" + date + ", localName=" + localName + ", name=" + name + ", countryCode="
				+ countryCode + ", fixed=" + fixed + ", global=" + global + ", launchYear=" + launchYear + ", types="
				+ types + "]";
	}
	
	
	
	
	
	
	

}
