
public class LeapYear {

	public static void main(String[] args) {
		int year = 2016;
		checkLeapYear(year);
		year = 1992;
		checkLeapYear(year);
		year = 2001;
		checkLeapYear(year);
		year = 1900;
		checkLeapYear(year);
		year = 2400;
		checkLeapYear(year);
	}

	public static void checkLeapYear(int year) {
		boolean b;
		b = ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) ? true : false;
		System.out.println("year = " + year + "; result = " + b + ";");
	}
}
