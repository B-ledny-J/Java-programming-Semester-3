package TSP_LB2;

import java.util.Scanner;

public class SwapFirstThirdOfNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Введіть чотиризначне ціле число: ");
		int a = sc.nextInt();
		if (Math.abs(a) < 1000 || Math.abs(a) > 9999) throw new IllegalArgumentException("Помилка: число не є чотиризначним.");
		int b = (a / 1000 * 10) + (a / 100 % 10 * 100) + (a / 10 % 10 * 1000) + (a % 10);
		System.out.println("Вхідне число a = " + a);
		System.out.println("Отримане число b (першу і третю цифри переставлено) = " + b);
	}
}