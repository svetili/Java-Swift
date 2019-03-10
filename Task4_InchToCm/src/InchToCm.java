
public class InchToCm {

	public static void main(String[] args) {
		final float INCH = 2.54f;
		int inchInt = 12;
		convertInchToCm(inchInt, INCH);
		float inchFloat = 23.23f;
		convertInchToCm(inchFloat, INCH);

	}
	
// use integer format
	public static void convertInchToCm(int inchToConvert, float INCH) {
		float res = INCH * inchToConvert;
		System.out.printf("%d inch(es) are %.04f centemeters.\n", inchToConvert, res);
	}
	
// use float format
	public static void convertInchToCm(float inchToConvert, float INCH) {	
		float res = INCH * inchToConvert;
		System.out.printf("%.2f inch(es) are %.4f centemeters.\n", inchToConvert, res);
	}
}
