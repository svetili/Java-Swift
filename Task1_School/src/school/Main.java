package school;

import java.sql.Connection;
import java.util.Scanner;

import school.DBConnector;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnector.setConnection();
		
		//MySqlSchoolData.insertTeacher(conn, sc);
		//MySqlSchoolData.getTeacher(conn, sc);
		//MySqlSchoolData.getTeachers(conn, sc);
		//MySqlSchoolData.insertStudent(conn, sc);
		//MySqlSchoolData.getStudent(conn, sc);
		//MySqlSchoolData.getStudents(conn, sc);
		//MySqlSchoolData.getDisciplinesByTeacherId(conn, sc);
		MySqlSchoolData.getTeachersByDisciplineName(conn, sc);
		
		sc.close();

	}

}
