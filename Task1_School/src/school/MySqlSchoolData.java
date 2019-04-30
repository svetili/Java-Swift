package school;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import java.util.Scanner;

public class MySqlSchoolData {

	public static int insertAddress(Connection conn, Scanner sc) {

		System.out.println("Country: ");
		String country = sc.nextLine();
		System.out.println("City: ");
		String city = sc.nextLine();
		System.out.println("Street: ");
		String street = sc.nextLine();
		System.out.println("Number: ");
		String nmbr = sc.nextLine();
		System.out.println("Floor (if no entry, type 0): ");
		Integer floor = Integer.parseInt(sc.nextLine());
		if (floor == 0) {
			floor = null;
		}
		System.out.println("Apartment No (if no entry, type 0): ");
		Integer apartment_no = Integer.parseInt(sc.nextLine());
		if (apartment_no == 0) {
			apartment_no = null;
		}

		try {
			CallableStatement stmnt = conn.prepareCall("{call ADD_ADDRESS (?, ?, ?, ?, ?, ?, ?)}");
			stmnt.setString("country", country);
			stmnt.setString("city", city);
			stmnt.setString("street", street);
			stmnt.setString("nmbr", nmbr);
			if (floor != null) {
				stmnt.setInt("floor", floor);
			} else {
				stmnt.setObject("floor", null);
			}
			if (apartment_no != null) {
				stmnt.setInt("apartment_no", apartment_no);
			} else {
				stmnt.setObject("apartment_no", null);
			}
			stmnt.registerOutParameter("address_id", Types.INTEGER);
			stmnt.execute();

			int addressId = stmnt.getInt("address_id");
			return addressId;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public static void insertTeacher(Connection conn, Scanner sc) {

		System.out.println("----------------------------Insert Teacher------------------------------");

		System.out.println("Name: ");
		String name = sc.nextLine();

		System.out.println("Salary: ");
		float salary = Float.parseFloat(sc.nextLine());

		System.out.println("Email: ");
		String email = sc.nextLine();

		System.out.println("Address >>> ");
		int addressId = insertAddress(conn, sc);

		try {

			CallableStatement stmnt = conn.prepareCall("{call ADD_TEACHER (?, ?, ?, ?, ?)}");

			stmnt.setString("name", name);
			stmnt.setFloat("salary", salary);
			stmnt.setString("email", email);
			stmnt.setInt("address_id", addressId);

			stmnt.registerOutParameter("teacher_id", Types.INTEGER);
			stmnt.execute();

			int teacherId = stmnt.getInt("teacher_id");
			System.out.println();
			System.out.println("Teacher with id " + teacherId + " was created.");
			System.out.println();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getTeacher(Connection conn, Scanner sc) {
		String query = "select teachers.name, teachers.salary, teachers.email, address.city, address.street, address.nmbr "
				+ "from teachers, address " + "where teachers.id = ? and teachers.address_id = address.id";

		System.out.println();
		System.out.println("----------------------------Get Teacher------------------------------");

		System.out.println("Teacher Id: ");
		int teacher_id = sc.nextInt();

		try {
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setInt(1, teacher_id);
			ResultSet rs = stmnt.executeQuery();
			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "name", "salary", "email", "city", "street", "nmbr");
			while (rs.next()) {
				System.out.printf("%s\t%.2f\t%s\t%s\t%s\t%s\n", rs.getString("name"), rs.getFloat("salary"),
						rs.getString("email"), rs.getString("city"), rs.getString("street"), rs.getString("nmbr"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getTeachers(Connection conn, Scanner sc) {
		String query = "select name, salary, email from teachers where teachers.salary > ? and teachers.salary < ?";

		System.out.println();
		System.out.println("------------------------- Get Teacher by Salaries ----------------------");
		System.out.println("Salary lower margin: ");
		float salaryL = sc.nextInt();
		System.out.println("Salary upper margin: ");
		float salaryU = sc.nextInt();

		try {
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setFloat(1, salaryL);
			stmnt.setFloat(2, salaryU);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				System.out.printf("%s\t%.2f\t%s\n", rs.getString("name"), rs.getFloat("salary"), rs.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertStudent(Connection conn, Scanner sc) {

		System.out.println("----------------------------Insert Student------------------------------");

		System.out.println("Name: ");
		String name = sc.nextLine();

		System.out.println("Enrollment date (yyyy-mm-dd): ");
		String enrollDateStr = sc.nextLine();
		Date enrollmentDate = Date.valueOf(enrollDateStr);

		System.out.println("Address >>> ");
		int addressId = insertAddress(conn, sc);

		try {
			CallableStatement stmnt = conn.prepareCall("{call ADD_STUDENT (?, ?, ?, ?)}");

			stmnt.setString("name", name);
			stmnt.setDate("enrollment_date", enrollmentDate);
			stmnt.setInt("address_id", addressId);

			stmnt.registerOutParameter("student_id", Types.INTEGER);
			stmnt.execute();

			int studentId = stmnt.getInt("student_id");
			System.out.println();
			System.out.println("Student with id " + studentId + " was created.");
			System.out.println();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getStudent(Connection conn, Scanner sc) {
		String query = "select students.name, students.enrollment_date, address.city, address.street, address.nmbr "
				+ "from students, address " + "where students.id = ? and students.address_id = address.id";

		System.out.println();
		System.out.println("----------------------------Get Student------------------------------");
		System.out.println("Student Id: ");
		int student_id = sc.nextInt();
		sc.nextLine();
		try {
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setInt(1, student_id);
			ResultSet rs = stmnt.executeQuery();
			System.out.printf("%s\t%s\t%s\t%s\t%s\n", "name", "enrollment_date", "city", "street", "nmbr");
			while (rs.next()) {
				System.out.printf("%s\t%tD\t%s\t%s\t%s\n", rs.getString("name"), rs.getDate("enrollment_date"),
						rs.getString("city"), rs.getString("street"), rs.getString("nmbr"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getStudents(Connection conn, Scanner sc) {
		String query = "select name, enrollment_date from students where students.enrollment_date > ? ";

		System.out.println();
		System.out.println("------------------------- Get Student by Enrollment Date ----------------------");
		System.out.println("Date to compare: ");
		String date_str = sc.nextLine();
		Date date = Date.valueOf(date_str);

		try {
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setDate(1, date);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				System.out.printf("%s\t%tD\n", rs.getString("name"), rs.getDate("enrollment_date"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getDisciplinesByTeacherId(Connection conn, Scanner sc) {
		String query = "select disciplines.name " + 
				"from disciplines, teachers, disciplines_taught " + 
				"where teachers.id = ? and teachers.id = disciplines_taught.teacher_id and disciplines_taught.discipline_id = disciplines.id";

		System.out.println();
		System.out.println("---------------------Get Disciplines By TeacherId----------------------");
		System.out.println("Teacher Id: ");
		int teacher_id = sc.nextInt();
		sc.nextLine();
		try {
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setInt(1, teacher_id);
			ResultSet rs = stmnt.executeQuery();
			System.out.println("Disciplines:");
			System.out.println("------------");
			while (rs.next()) {
				System.out.printf("%s\n", rs.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getTeachersByDisciplineName(Connection conn, Scanner sc) {
		String query = "select teachers.name " + 
				"from disciplines, teachers, disciplines_taught " + 
				"where disciplines.name = ? and disciplines.id = disciplines_taught.discipline_id and disciplines_taught.teacher_id = teachers.id";

		System.out.println();
		System.out.println("---------------------Get Disciplines By TeacherId----------------------");
		System.out.println("Discipline: ");
		String discipline = sc.nextLine();
		try {
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setString(1, discipline);
			ResultSet rs = stmnt.executeQuery();
			System.out.println("Teachers:");
			System.out.println("------------");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
