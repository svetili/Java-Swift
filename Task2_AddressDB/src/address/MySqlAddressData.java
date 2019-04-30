package address;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class MySqlAddressData {

	public static void printFullAddress(ResultSet rs) throws SQLException {
		System.out.printf("%s %s Street", rs.getString("nmbr"), rs.getString("street"));
		if (rs.getObject("apartmentno") != null) {
			System.out.printf(", Ap. %s\n", rs.getInt("apartmentno"));
		} else {
			System.out.println();
		}
		System.out.printf("%s, %s\n", rs.getString("municipality"), rs.getString("populated_area"));
		System.out.printf("%s, %s\n", rs.getString("region"), rs.getString("country"));
	}

	public static void printAddress(ResultSet rs) throws SQLException {
		System.out.printf("%s %s Street", rs.getString("nmbr"), rs.getString("street"));
		if (rs.getObject("apartmentno") != null) {
			System.out.printf(", Ap. %s", rs.getInt("apartmentno"));
		}
		System.out.printf(" %s, %s, %s, %s\n", rs.getString("municipality"), rs.getString("populated_area"),
				rs.getString("region"), rs.getString("country"));
	}

	public static int addCountry(Connection conn, Scanner sc) {
		System.out.println("Country: ");
		String country = sc.nextLine();
		try {
			CallableStatement stmnt = conn.prepareCall("{call add_country (?, ?)}");
			stmnt.setString("country", country);
			stmnt.registerOutParameter("country_id", Types.INTEGER);
			stmnt.execute();

			int countryId = stmnt.getInt("country_id");
			return countryId;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public static int addRegion(Connection conn, Scanner sc, int country_id) {
		System.out.println("Region: ");
		String region = sc.nextLine();
		try {
			CallableStatement stmnt = conn.prepareCall("{call add_region (?, ?, ?)}");
			stmnt.setString("region", region);
			stmnt.setInt("country_id", country_id);
			stmnt.registerOutParameter("region_id", Types.INTEGER);
			stmnt.execute();

			int regionId = stmnt.getInt("region_id");
			return regionId;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public static int addType(Connection conn, Scanner sc) {
		System.out.println("Populated area type: ");
		String populated_area_type = sc.nextLine();
		try {
			CallableStatement stmnt = conn.prepareCall("{call add_type (?, ?)}");
			stmnt.setString("populated_area_type", populated_area_type);
			stmnt.registerOutParameter("type_id", Types.INTEGER);
			stmnt.execute();

			int typeId = stmnt.getInt("type_id");
			return typeId;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public static int addPopulatedArea(Connection conn, Scanner sc, int type_id, int region_id) {
		System.out.println("Populated area: ");
		String populated_area = sc.nextLine();
		try {
			CallableStatement stmnt = conn.prepareCall("{call add_populated_area (?, ?, ?, ?)}");
			stmnt.setString("populated_area", populated_area);
			stmnt.setInt("type_id", type_id);
			stmnt.setInt("region_id", region_id);
			stmnt.registerOutParameter("populated_area_id", Types.INTEGER);
			stmnt.execute();

			int populatedAriaId = stmnt.getInt("populated_area_id");
			return populatedAriaId;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public static int addMunicipality(Connection conn, Scanner sc, int populated_area_id) {
		System.out.println("Municipality: ");
		String municipality = sc.nextLine();
		System.out.println("Postal code: ");
		String postal_code = sc.nextLine();
		try {
			CallableStatement stmnt = conn.prepareCall("{call add_municipality (?, ?, ?, ?)}");
			stmnt.setString("municipality", municipality);
			stmnt.setString("postal_code", postal_code);
			stmnt.setInt("populated_area_id", populated_area_id);
			stmnt.registerOutParameter("municipality_id", Types.INTEGER);
			stmnt.execute();

			int municipalityId = stmnt.getInt("municipality_id");
			return municipalityId;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public static int addStreet(Connection conn, Scanner sc, int municipality_id) {
		System.out.println("Street: ");
		String street = sc.nextLine();
		try {
			CallableStatement stmnt = conn.prepareCall("{call add_street (?, ?, ?)}");
			stmnt.setString("street", street);
			stmnt.setInt("municipality_id", municipality_id);
			stmnt.registerOutParameter("street_id", Types.INTEGER);
			stmnt.execute();

			int streetId = stmnt.getInt("street_id");
			return streetId;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public static int addAddress(Connection conn, Scanner sc) {

		int country_id = addCountry(conn, sc);
		int region_id = addRegion(conn, sc, country_id);
		int type_id = addType(conn, sc);
		int populated_area_id = addPopulatedArea(conn, sc, type_id, region_id);
		int municipality_id = addMunicipality(conn, sc, populated_area_id);
		int street_id = addStreet(conn, sc, municipality_id);
		System.out.println("Number: ");
		String nmbr = sc.nextLine();
		System.out.println("Apartment No (if no entry, type 0): ");
		Integer apartment_no = Integer.parseInt(sc.nextLine());
		if (apartment_no == 0) {
			apartment_no = null;
		}

		try {
			CallableStatement stmnt = conn.prepareCall("{call ADD_ADDRESS (?, ?, ?, ?)}");
			stmnt.setInt("street_id", street_id);
			stmnt.setString("nmbr", nmbr);
			if (apartment_no != null) {
				stmnt.setInt("apartmentno", apartment_no);
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

	public static void getFullAddress(Connection conn, Scanner sc) {

		System.out.println();
		System.out.println("------------------------ Get Full Address by Id ---------------------------");

		String query = "SELECT " + "    addresses.nmbr, " + "    addresses.apartmentno, "
				+ "    streets.name           AS street, " + "    municipalities.name    AS municipality, "
				+ "    populated_areas.name   AS populated_area, " + "    regions.name           AS region, "
				+ "    countries.name         AS country " + "FROM " + "    addresses, " + "    countries, "
				+ "    municipalities, " + "    populated_areas, " + "    regions, " + "    streets " + "WHERE "
				+ "	 addresses.id = ?" + "    AND addresses.street_id = streets.id "
				+ "    AND streets.municipality_id = municipalities.id "
				+ "    AND municipalities.populated_area_id = populated_areas.id "
				+ "    AND populated_areas.region_id = regions.id " + "    AND regions.country_id = countries.id";

		System.out.println("Address Id: ");
		int address_id = sc.nextInt();
		sc.nextLine();
		try {
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setInt(1, address_id);
			ResultSet rs = stmnt.executeQuery();
			System.out.println("Address info:");
			while (rs.next()) {
				printFullAddress(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getAddresses(Connection conn, Scanner sc) {

		System.out.println();
		System.out.println("------------------------ Get Addresses by  Municipality Name ---------------------------");

		String query = "SELECT " + "    addresses.nmbr, " + "    addresses.apartmentno, "
				+ "    streets.name           AS street, " + "    municipalities.name    AS municipality, "
				+ "    populated_areas.name   AS populated_area, " + "    regions.name           AS region, "
				+ "    countries.name         AS country " + "FROM\r\n" + "    addresses, " + "    countries, "
				+ "    municipalities, " + "    populated_areas, " + "    regions, " + "    streets " + "WHERE "
				+ "    addresses.street_id = streets.id " + "    AND streets.municipality_id = municipalities.id "
				+ "    AND municipalities.name = ?" + "    AND municipalities.populated_area_id = populated_areas.id "
				+ "    AND populated_areas.region_id = regions.id " + "    AND regions.country_id = countries.id";

		System.out.println("Municipality name: ");
		String municipality_name = sc.nextLine();
		try {
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setString(1, municipality_name);
			ResultSet rs = stmnt.executeQuery();
			System.out.printf("Addresses in %s municipality:\n", municipality_name);
			while (rs.next()) {
				printAddress(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
