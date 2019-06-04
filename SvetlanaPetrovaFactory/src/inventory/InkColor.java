package inventory;

import java.util.Random;

public enum InkColor {
	BLUE, GREEN, RED, BLACK;
	
	public static InkColor getRandomColor() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
