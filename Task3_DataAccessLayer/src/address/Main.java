package address;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MySqlAddressStorage mySql = new MySqlAddressStorage();

		getAddress(mySql, sc);
		insertAddress(mySql, sc);

		sc.close();
	}

	private static void getAddress(MySqlAddressStorage mySql, Scanner sc) {
		try {
			System.out.println("Addres Id: ");
			int addressId = sc.nextInt();
			sc.nextLine();
			Address address = mySql.getAddress(addressId);
			System.out.println(address);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void insertAddress(MySqlAddressStorage mySql, Scanner sc) {
		try {
			System.out.println("Country: ");
			String country = sc.nextLine();

			System.out.println("City: ");
			String city = sc.nextLine();

			System.out.println("Municipality: ");
			String municipality = sc.nextLine();

			System.out.println("Postal code: ");
			String postal_code = sc.nextLine();

			System.out.println("Street: ");
			String street = sc.nextLine();

			System.out.println("Number: ");
			String nmbr = sc.nextLine();

			System.out.println("Floor No (if no entry, type 0): ");
			Integer floor = Integer.parseInt(sc.nextLine());
			if (floor == 0) {
				floor = null;
			}

			System.out.println("Apartment No (if no entry, type 0): ");
			Integer apartment_no = Integer.parseInt(sc.nextLine());
			if (apartment_no == 0) {
				apartment_no = null;
			}
			Address address = new Address(country, city, municipality, postal_code, street, nmbr, floor, apartment_no);
			mySql.insertAddress(address);
			System.out.println(address);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

}
