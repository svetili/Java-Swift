
public class SecondsInBiggerIntervals {
	
	public static void main(String[] args) {
		int seconds = 1234567;
		formatPrintSeconds(seconds);
		seconds = 3600;
		formatPrintSeconds(seconds);
		seconds = 129600;
		formatPrintSeconds(seconds);
	}

	public static void formatPrintSeconds(int seconds) {
		byte secondsF = (byte) (seconds % 60);
		byte minutesF = (byte) (seconds / 60 % 60);
		byte hoursF = (byte) (seconds / (60 * 60) % 24);
		int daysF = seconds / (60 * 60 * 24);
		System.out.printf("%d second(s) are %d day(s), %d hour(s), %d minute(s), %d second(s)\n", seconds, daysF, hoursF,
				minutesF, secondsF);
	}
}
