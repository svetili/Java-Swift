import java.util.Scanner;

public class InterfaceMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// fill persons list
		String perString = sc.nextLine();
		String[] strArr1 = perString.split(";");
		Person[] perArr = new Person[strArr1.length];
		for (int i = 0; i < strArr1.length; i++) {
			String[] strProp = strArr1[i].split("=");
			String name = strProp[0].trim();
			double balance = Double.parseDouble(strProp[1].trim());
			if (balance < 0) {
				System.out.println("Balance can’t be negative.");
				sc.close();
				return;
			} else if ("".equals(name)) {
				System.out.println("Name can’t be empty");
				sc.close();
				return;
			} else {
				perArr[i] = new Person(name, balance);
			}
		}

		// fill products list
		// TODO find if there is a way to make template because the only differences
		// with the upper code is the class
		// and the name of the double attribute
		String prodString = sc.nextLine();
		String[] strArr2 = prodString.split(";");
		Product[] prodArr = new Product[strArr2.length];
		for (int i = 0; i < strArr2.length; i++) {
			String[] strProp = strArr2[i].split("=");
			String name = strProp[0].trim();
			double price = Double.parseDouble(strProp[1].trim());
			if (price < 0) {
				System.out.println("Price can’t be negative.");
				sc.close();
				return;
			} else if ("".equals(name)) {
				System.out.println("Product name can’t be empty");
				sc.close();
				return;
			} else {
				prodArr[i] = new Product(name, price);
			}
		}

		// fill operations
		boolean op = false;
		String s = sc.nextLine();
		while (!"END".equals(s)) {
			int i = 0;
			while (!s.startsWith(perArr[i].getName())) {
				i++;
			}
			if (i == perArr.length) {
				System.out.println("Person name not found.");
			}
			int j = 0;
			while (!s.startsWith(prodArr[j].getName(), perArr[i].getName().length() + 1)) {
				j++;
			}
			if (j == prodArr.length) {
				System.out.println("Product name is not found");
			}
			double balance = perArr[i].getBalance();
			double price = prodArr[j].getPrice();
			String perName = perArr[i].getName();
			String prodName = prodArr[j].getName();
			if (balance >= price) {
				op = true;
				perArr[i].changeBalance(price);
				perArr[i].setPurchases(prodName);
				System.out.println(perName + " bought " + prodName);
			} else {
				System.out.println(perName + " can't affort " + prodName);
			}
			s = sc.nextLine();
		}
		sc.close();
		if (op) {
			for (int i = 0; i < perArr.length; i++) {
				System.out.println(perArr[i].getName() + " - " + perArr[i].getPurchases());
			}
		} else {
			System.out.println("Nothing bought!");
		}
	}

}
