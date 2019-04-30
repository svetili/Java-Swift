package address;


import java.sql.Connection;
import java.util.Scanner;

import address.DBConnector;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnector.setConnection();
		
		//MySqlAddressData.getFullAddress(conn, sc);
		//MySqlAddressData.getAddresses(conn, sc);
		MySqlAddressData.addAddress(conn, sc);
		
		sc.close();

	}

}
