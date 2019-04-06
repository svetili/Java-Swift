package stack;

import java.util.Scanner;

public class StackMax {
	int[] stackArr;
	int index;
	int[] elemMaxArr;
	int elemMaxIndex;

	public StackMax() {
		stackArr = new int[100];
		index = -1;
		elemMaxArr = new int[100];
		elemMaxIndex = -1;
	}

	public void push(int n) {
		index++;
		stackArr[index] = n;

		if (elemMaxIndex == -1 || n >= elemMaxArr[elemMaxIndex]) {
			elemMaxIndex++;
			elemMaxArr[elemMaxIndex] = n;
		}
	}

	public int max() {
		if (elemMaxIndex != -1) {
			return elemMaxArr[elemMaxIndex];
		} else {
			System.out.println("The stack is empty!");
		}
		return Integer.MIN_VALUE;
	}

	public int pop() {
		try {
			int n = stackArr[index];
			index--;
			if (elemMaxIndex != -1 && n == elemMaxArr[elemMaxIndex]) {
				elemMaxIndex--;
			}
			return n;
		} catch (Exception e) {
			System.out.println("The stack is empty!");
		}
		return -1;
	}

	public void printInfo() {
		while (index >= 0) {
			System.out.print(pop() + " ");
		}
	}

	public static void main(String[] args) {
		StackMax stack = new StackMax();
		System.out.println("Enter PUSH number/POP/MAX! If you want to end - enter END!");
		Scanner sc = new Scanner(System.in);
		String strTmp = sc.nextLine();
		while (!"END".equals(strTmp)) {
			try {
				String[] strArr = strTmp.split(" ");
				switch (strArr[0]) {
				case "PUSH":
					stack.push(Integer.parseInt(strArr[1]));
					break;
				case "POP":
					System.out.println(stack.pop());
					break;
				case "MAX":
					System.out.println(stack.max());
				}
			} catch (Exception e) {
				System.out.println("Wrong input!");
			}
			strTmp = sc.nextLine();
		}

		stack.printInfo();
		sc.close();

	}

}
