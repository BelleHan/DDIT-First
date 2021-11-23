package kr.or.ddit.flight;

public class FlightDTO {	
	private String flightId;
	private String depTime;
	private String arrTime;
	private String depAirport;
	private String arrAirport;
	private String airlineId;
	private String airlineName;
	private int price;
	
	public FlightDTO(String depAirport, String arrAirport, String depTime) {
		this.depAirport = depAirport;
		this.arrAirport = arrAirport;
		this.depTime = depTime;
	}

	public FlightDTO(String flightId, String depTime, String arrTime, String depAirport, String arrAirport,
			String airlineId, String airlineName, int price) {
		super();
		this.flightId = flightId;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.depAirport = depAirport;
		this.arrAirport = arrAirport;
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.price = price;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public String getDepAirport() {
		return depAirport;
	}

	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}

	public String getArrAirport() {
		return arrAirport;
	}

	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FlightDTO [flightId=" + flightId + ", depTime=" + depTime + ", arrTime=" + arrTime + ", depAirport="
				+ depAirport + ", arrAirport=" + arrAirport + ", airlineId=" + airlineId + ", airlineName="
				+ airlineName + ", price=" + price + "]";
	}
	
	
	
	
}
