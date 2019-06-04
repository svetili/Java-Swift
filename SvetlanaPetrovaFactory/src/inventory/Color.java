package inventory;

import java.util.Random;

public enum Color {
 PINK, YELLOW, BLUE, GREY, METALIC, GREEN;
	
	public static Color getRandomColor() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
