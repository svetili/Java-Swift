package address;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import connection.DBConnector;

public class MySqlAddressStorage implements AddressStorage {
	Connection conn;

	public MySqlAddressStorage() {
		this.conn = DBConnector.setConnection();
	}

	public Address getAddress(ResultSet rs) throws SQLException {
		Address	addr = new Address(rs.getString("country"), rs.getString("city"), rs.getString("municipality"), rs.getString("postal_code"),
					rs.getString("street"), rs.getString("nmbr"), rs.getObject("floor"), rs.getObject("apartmentno"));
		return addr;
	}

	@Override
	public Address getAddress(int address_id) throws DALException {
		String query = "select * from addresses where id = ?";
		try {
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setInt(1, address_id);
			ResultSet rs = stmnt.executeQuery();
			System.out.println("Address info:");
			rs.next();
			Address addr = getAddress(rs);
			return addr;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public int insertAddress(Address address) throws DALException {
		String country = address.getCountry();
		String city = address.getCity();
		String municipality = address.getMunicipality();
		String postalCode = address.getPostalCode();
		String street = address.getStreet();
		String nmbr = address.getNumber();
		Integer floor = address.getApartmentNo();
		Integer apartmentNo = address.getApartmentNo();

		try {
			CallableStatement stmnt = conn.prepareCall("{call ADD_ADDRESS (?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			stmnt.setString("country", country);
			stmnt.setString("city", city);
			stmnt.setString("municipality", municipality);
			stmnt.setString("postal_code", postalCode);
			stmnt.setString("street", street);
			stmnt.setString("nmbr", nmbr);
			if (floor != 0) {
				stmnt.setInt("floor", floor);
			} else {
				stmnt.setObject("floor", null);
			}
			if (apartmentNo != 0) {
				stmnt.setInt("apartmentno", apartmentNo);
			} else {
				stmnt.setObject("apartmentno", null);
			}
			stmnt.registerOutParameter("address_id", Types.INTEGER);
			stmnt.execute();

			int addressId = stmnt.getInt("address_id");

			System.out.println("Address id: " + addressId);
			return addressId;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

}
