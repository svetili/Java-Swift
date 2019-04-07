package person;

public class Address {
	private String country;
	private String city;
	private String municipality;
	private String postalCode;
	private String street;
	private String number;
	private String floor;
	private String apartmentNo;
	
	public Address(String country, String city, String municipality, String postalCode, String street, String number) {
		this.country = country;
		this.city = city;
		this.municipality = municipality;
		this.postalCode = postalCode;
		this.street = street;
		this.number = number;
		this.floor = "";
		this.apartmentNo = "";
	}
	
	public Address(String country, String city, String municipality, String postalCode, String street, String number,
			String floor, String apartmentNo) {
		this.country = country;
		this.city = city;
		this.municipality = municipality;
		this.postalCode = postalCode;
		this.street = street;
		this.number = number;
		this.floor = floor;
		this.apartmentNo = apartmentNo;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getMunicipality() {
		return municipality;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getStreet() {
		return street;
	}

	public String getNumber() {
		return number;
	}

	public String getFloor() {
		return floor;
	}

	public String getApartmentNo() {
		return apartmentNo;
	}

	@Override
	public String toString() {
		String s = String.format("%s %s Street\n%s %s\n%s, %s\n", 
				this.getNumber(), this.getStreet(), this.getPostalCode(), this.getMunicipality(), this.getCity(), this.getCountry());
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Address) {
		return this.getApartmentNo().equals(((Address)obj).getApartmentNo()) &&
				this.getCity().equals(((Address)obj).getCity()) &&
				this.getCountry().equals(((Address)obj).getCountry()) &&
				this.getFloor().equals(((Address)obj).getFloor()) &&
				this.getMunicipality().equals(((Address)obj).getMunicipality()) &&
				this.getNumber().equals(((Address)obj).getNumber()) &&
				this.getPostalCode().equals(((Address)obj).getPostalCode()) &&
				this.getStreet().equals(((Address)obj).getStreet())
				;
		}
		return false;
	}
	
}
