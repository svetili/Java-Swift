package expression;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter mathematical expression:");
		String line = sc.nextLine();
		double d = manageString(line);
		System.out.printf("%.6f", d);
		sc.close();
	}

	public static double manageString(String line) {
		int i = 0;
		Expression rootElement = null, expr2 = null;
		while (i < line.length()) {
			double d1, d2;
			Operator op = Operator.None;
			char ch = line.charAt(i);

			// read first number (only the first time);
			// manage brackets recursively
			if (rootElement == null) {
				if (ch == '(') {
					int j = line.indexOf(')', i);
					d1 = manageString(line.substring(i + 1, j));
					i = j + 1;
				} else {
					int j = i + 1;
					while (line.charAt(j) != '+' && line.charAt(j) != '-' && line.charAt(j) != '*'
							&& line.charAt(j) != '/' && line.charAt(j) != '^') {
						j++;
					}
					d1 = Double.parseDouble(line.substring(i, j));
					i = j;
				}
				rootElement = new Expression(d1);
			}

			// read operator
			if (i < line.length()) {

				ch = line.charAt(i);
				switch (ch) {
				case '+':
					op = Operator.Plus;
					break;
				case '-':
					op = Operator.Minus;
					break;
				case '*':
					op = Operator.Multiply;
					break;
				case '/':
					op = Operator.Division;
					break;
				case '^':
					op = Operator.Power;
					break;
				}
				i++;

				// read second number
				// manage brackets recursively
				ch = line.charAt(i);
				if (ch == '(') {
					int j = line.indexOf(')', i);
					d2 = manageString(line.substring(i + 1, j));
					i = j + 1;
				} else {
					int j = i + 1;
					while (j < line.length() && line.charAt(j) != '+' && line.charAt(j) != '-' && line.charAt(j) != '*'
							&& line.charAt(j) != '/' && line.charAt(j) != '^') {
						j++;
						if (j == line.length()) {
							break;
						}
					}
					d2 = Double.parseDouble(line.substring(i, j));
					i = j;
				}
				expr2 = new Expression(d2);

				// make a new element and add it in the tree according to operator priority
				rootElement = addElement(op, rootElement, expr2);
			}
		}
		return rootElement.getValue();
	}
	
	public static Expression addElement(Operator op, Expression rootElement, Expression element){
		Expression newElement;
		boolean b = rootElement.getOperator().equals(Operator.None);
		int i = op.getValue() - rootElement.getOperator().getValue();
		if (!b && i > 0) {
			Expression exTmp = rootElement.getRight();
			newElement = addElement(op, exTmp, element);
			rootElement.setRight(newElement);
		}else {
			newElement = new Expression(op, rootElement, element);
			rootElement = newElement;
		}
		return rootElement;
	}
}
