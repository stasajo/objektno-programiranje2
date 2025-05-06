package model.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HolidayType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "holiday_id")
	private Holiday holiday;

	public HolidayType() {
		super();
	}

	public HolidayType(String type, Holiday holiday) {
		super();
		this.type = type;
		this.holiday = holiday;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Holiday getHoliday() {
		return holiday;
	}

	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}

	@Override
	public String toString() {
		return "HolidayType [id=" + id + ", type=" + type + ", holiday=" + holiday + "]";
	}
	
	
	
	
	
	
	

}
