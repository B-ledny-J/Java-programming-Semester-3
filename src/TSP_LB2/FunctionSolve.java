package TSP_LB2;

import java.util.Scanner;

public class FunctionSolve {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введіть значення x: ");
		double x = scanner.nextDouble();
		if (x == 0) throw new IllegalArgumentException("x не може дорівнювати 0");
		double f = Math.pow(x + (2 / Math.pow(x, 2)) + (3 / Math.pow(x, 3)), 2);
		System.out.println("Результат обчислення функції: " + f);
	}
}