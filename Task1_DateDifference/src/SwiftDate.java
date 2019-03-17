import java.util.Scanner;

public class SwiftDate {

	private short year;
	private byte month;
	private byte day;

	public SwiftDate() {
		this.year = 0;
		this.month = 1;
		this.day = 1;
	}

	public SwiftDate(short year, byte month, byte day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// year
	public short getYear() {
		return this.year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	// month
	public byte getMonth() {
		return this.month;
	}

	public void setMonty(byte month) {
		this.month = month;
	}

	// day
	public byte getDay() {
		return this.day;
	}

	public void setDay(byte day) {
		this.day = day;
	}

	// instance method for leap year
	public boolean isLeapYear() {
		short year = this.getYear();
		return ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) ? true : false;
	}

	// class method for leap year
	public static boolean isLeapYear(short year) {
		return ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) ? true : false;
	}

	// century
	public int getCentury() {
		return this.getYear() / 100 + 1;
	}

	// how many days has a given as parameter month, the year is the year of the
	// current object
	public byte getDaysInMonth(byte month) {
		if (month == 2 && this.isLeapYear()) {
			return 29;
		}
		switch (month) {
		case 1:
			;
		case 3:
			;
		case 5:
			;
		case 7:
			;
		case 8:
			;
		case 10:
			;
		case 12:
			return 31;
		case 2:
			return 28;
		default:
			return 30;
		}
	}

	// difference between current object day and a given other day
	// the only objective is to simplify a little the main method
	public int getDaysDifference(byte day) {
		int result = 0;
		if (this.getDay() >= day) {
			result = this.getDay() - day + 1;
		} else {
			result = day - this.getDay() + 1;
		}
		return result;
	}

	public int getDaysDifference(SwiftDate other) {
		int result = 0;
		// store repeated calls
		short yearT = this.getYear();
		short yearO = other.getYear();
		byte monthT = this.getMonth();
		byte monthO = other.getMonth();
		// the main case ... the other cases will be generated recursively to avoid
		// repeated sequences
		if (yearT == yearO) {
			if (monthT == monthO) {
				// the only difference (if any) is in the days
				result = this.getDaysDifference(other.getDay());
			} else if (monthT > monthO) {
				// get the months between and accumulate their full number of days
				for (byte i = (byte) (monthO + 1); i < monthT; i++) {
					result += this.getDaysInMonth(i);
				}
				// for the border months subtract the day from the beginning or the end of the
				// month
				result = other.getDaysDifference(other.getDaysInMonth(monthO)) + this.getDaysDifference((byte) 1)
						+ result;

			} else {
				// get the months between and accumulate their full number of days
				for (byte i = (byte) (monthT + 1); i < monthO; i++) {
					result += this.getDaysInMonth(i);
				}
				// for the border months subtract the day from the beginning or the end of the
				// month
				result = this.getDaysDifference(this.getDaysInMonth(monthT)) + other.getDaysDifference((byte) 1)
						+ result;
			}
			// recursive case 1
		} else if (yearT > yearO) {

			for (short i = (short) (yearO + 1); i < yearT; i++) {
				result += (isLeapYear(i)) ? 366 : 365;
			}
			SwiftDate dateO = new SwiftDate(yearO, (byte) 12, (byte) 31);
			result += other.getDaysDifference(dateO);
			SwiftDate dateT = new SwiftDate(yearT, (byte) 1, (byte) 1);
			result += this.getDaysDifference(dateT);
			// recursive case 2
		} else {
			for (short i = (short) (yearT + 1); i < yearO; i++) {
				result += (isLeapYear(i)) ? 366 : 365;
			}
			SwiftDate dateT = new SwiftDate(yearT, (byte) 12, (byte) 31);
			result += this.getDaysDifference(dateT);
			SwiftDate dateO = new SwiftDate(yearO, (byte) 1, (byte) 1);
			result += other.getDaysDifference(dateO);
		}
		return result;
	}

	public void printInfo() {

		System.out.printf("%d %02d %02d - %d century.", this.getYear(), (int) (this.getMonth()), (int) (this.getDay()),
				this.getCentury());
		if (this.isLeapYear()) {
			System.out.println("It is LEAP year.");
		} else {
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two dates with format \"yyyy MM dd\"");
		short year1 = sc.nextShort();
		byte month1 = sc.nextByte();
		byte day1 = sc.nextByte();
		SwiftDate date1 = new SwiftDate(year1, month1, day1);

		short year2 = sc.nextShort();
		byte month2 = sc.nextByte();
		byte day2 = sc.nextByte();
		SwiftDate date2 = new SwiftDate(year2, month2, day2);

		int diff = date1.getDaysDifference(date2);
		System.out.println(diff);
		date1.printInfo();
		date2.printInfo();
		sc.close();
	}

}
