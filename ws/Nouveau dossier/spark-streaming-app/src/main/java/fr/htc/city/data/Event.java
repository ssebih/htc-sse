package fr.htc.city.data;

public class Event {
	private String city;
	private String date;
	private Integer value;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public static Event parse(String lineEvent) {
		String[] columns = lineEvent.split(";");
		Event event = new Event();
		event.setDate(columns[0]);
		event.setCity(columns[1]);
		event.setValue(Integer.parseInt(columns[2]));
		return event;
	}

	@Override
	public String toString() {
		return "Event [city=" + city + ", date=" + date + ", value=" + value + "]";
	}

	
}
