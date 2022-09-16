package entity;

public class Address {
	private String streetAdd, city, state;
	private int postalCode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String streetAdd, String city, String state, int postalCode) {
		super();
		this.streetAdd = streetAdd;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	public String getStreetAdd() {
		return streetAdd;
	}

	public void setStreetAdd(String streetAdd) {
		this.streetAdd = streetAdd;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}  
	

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Address [streetAdd=" + streetAdd + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode
				+ "]";
	}

}
