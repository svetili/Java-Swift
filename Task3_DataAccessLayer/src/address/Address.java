package address;

public class Address {
	private String country;
	private String city;
	private String municipality;
	private String postalCode;
	private String street;
	private String number;
	private Integer floor;
	private Integer apartmentNo;

	public Address(String country, String city, String municipality, String postalCode, String street, String number,
			Object floor, Object apartmentNo) {
		this.country = country;
		this.city = city;
		this.municipality = municipality;
		this.postalCode = postalCode;
		this.street = street;
		this.number = number;
		if (floor instanceof Integer) {
			this.floor = (Integer) floor;
		}
		if (apartmentNo instanceof Integer) {
			this.apartmentNo = (Integer) apartmentNo;
		}
	}

	public String getCountry() {
		return country;
	}

	protected String getCity() {
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

	protected Integer getFloor() {
		if (floor != null) {
			return floor;
		} else {
			return 0;
		}
	}

	public int getApartmentNo() {
		if (apartmentNo != null) {
			return apartmentNo;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		String s = String.format("%s %s Street\n%s %s\n%s, %s\n", this.getNumber(), this.getStreet(),
				this.getPostalCode(), this.getMunicipality(), this.getCity(), this.getCountry());
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Address) {
			Address addr = (Address) obj;
			return this.getApartmentNo() == addr.getApartmentNo() && this.getFloor() == addr.getFloor()
					&& this.getCity().equals(addr.getCity()) && this.getCountry().equals(addr.getCountry())
					&& this.getMunicipality().equals(addr.getMunicipality())
					&& this.getNumber().equals(addr.getNumber()) && this.getPostalCode().equals(addr.getPostalCode())
					&& this.getStreet().equals(addr.getStreet());
		}
		return false;
	}

}
