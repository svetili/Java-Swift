package inventory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {

	public static float randInt(float min, float max) {
		Random rand = new Random();
		float result = rand.nextFloat() * (max - min) + min;
		return result;
	}

	public static boolean getRandomBoolean() {
		return Math.random() < 0.5;
	}

	public static void main(String[] args) {
		Writable[] writable = new Writable[50];

		for (int i = 0; i < 25; i++) {
			Color color = Color.getRandomColor();
			String brand = "brand" + i; // this should be changed to enum (like the color) but I don't have time
			float weight = randInt(0.1f, 500.0f);
			InkColor inkColor = InkColor.getRandomColor();
			String inkType = "ink" + i; // this should be changed to enum (like the color) but I don't have time
			float fillerThickness = randInt(0.01f, 1.0f);
			boolean permanent = getRandomBoolean();
			try {
				writable[i] = new Marker(color, brand, weight, inkColor, inkType, fillerThickness, permanent);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		for (int i = 25; i < 50; i++) {
			Color color = Color.getRandomColor();
			String brand = "brand" + i;
			InkColor inkColor = InkColor.getRandomColor();
			writable[i] = new Pen(color, brand, inkColor);
		}
		List<Writable> writableList = new ArrayList<>();
		for (Writable w : writable) {
			writableList.add(w);
		}
		
		Iterator<Writable> iter = writableList.iterator();
		boolean even = false;
		while(iter.hasNext()) {
			Writable writ = iter.next();
			if (even == true) {
				if (writ.getInkColor() == InkColor.BLUE) {
					writ.print();
				}
				even = false;
			} else {
				even = true;
			}
		}
		

	}

}
