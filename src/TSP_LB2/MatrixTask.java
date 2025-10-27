package TSP_LB2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MatrixTask {

	public static void main(String[] args) {
		final int SIZE = 5;
		int[][] A = new int[SIZE][SIZE];
		int[][] B = new int[SIZE][SIZE];
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("Введіть 0, щоб заповнити матрицю випадково, або будь-яке інше число, щоб заповнити вручну: ");
			if (sc.hasNextInt() && sc.nextInt() == 0)
			{
				int min, max;
				System.out.print("Введіть мінімально допустиме значення в матриці: ");
				if (!sc.hasNextInt()) throw new InputMismatchException();
				min = sc.nextInt();
				System.out.print("Введіть максимально допустиме значення в матриці: ");
				if (!sc.hasNextInt()) throw new InputMismatchException();
				max = sc.nextInt();
				if (min > max) throw new IllegalArgumentException();
				System.out.println();
				fillRandom(A, min, max);
			}
			else
			{
				sc.nextLine();
				System.out.print ("Введіть елементи матриці 5x5 (через пробіл або Enter): ");
				fillManual(A, sc);
			}
			System.out.println("Матриця A:");
			printMatrix(A);
			double avgAbove = averageAboveMainDiagonal(A);
			double avgBelow = averageBelowMainDiagonal(A);
			System.out.printf("Середнє над головною діагоналлю: %.2f%n\n", avgAbove);
			System.out.printf("Середнє під головною діагоналлю: %.2f%n\n", avgBelow);
			reflectSecondaryDiagonal(A, B);
			System.out.println("Матриця B (симетрична відносно другорядної діагоналі):");
			printMatrix(B);

		}
		catch (InputMismatchException e)
		{
			System.out.println("Помилка: введено неціле число.");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Помилка: введено недостатню кількість елементів.");
		}
		catch (IllegalArgumentException e)
		{
			System.out.print("Помилка: min не може бути більшим за max.");
		}
		catch (Exception e)
		{
			System.out.println("Невідома помилка: " + e.getMessage());
		}
	}

	private static void fillRandom(int[][] A, int min, int max)
	{
		Random rand = new Random();
		for (int i = 0; i < A.length; i++) for (int j = 0; j < A[i].length; j++) A[i][j] = rand.nextInt(max - min + 1) + min;
	}

	// Опять не понимаю, как работают рядки, и почему они так записываются то через Enter, то через пробел и почему можно не писать ввод для каждого элемента отдельно
	private static void fillManual(int[][] A, Scanner sc)
	{
		for (int i = 0; i < A.length; i++)
		{
			System.out.print("Рядок " + (i + 1) + ": ");
			for (int j = 0; j < A[i].length; j++)
			{
				if (!sc.hasNextInt()) throw new InputMismatchException();
				A[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}
	}

	private static void printMatrix(int[][] M)
	{
		for (int[] row : M) //цикл for-each
		{
			for (int val : row) System.out.printf("%5d", val);
			System.out.println();
		}
		System.out.println();
	}

	private static double averageAboveMainDiagonal(int[][] A)
	{
		int sum = 0, count = 0;
		for (int i = 0; i < A.length; i++)
			for (int j = i + 1; j < A[i].length; j++)
			{
				sum += A[i][j];
				count++;
			}
		return (double) sum / count;
	}

	private static double averageBelowMainDiagonal(int[][] A)
	{
		int sum = 0, count = 0;
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < i; j++)
			{
				sum += A[i][j];
				count++;
			}
		return (double) sum / count;
	}

	private static void reflectSecondaryDiagonal(int[][] A, int[][] B)
	{
		int n = A.length;
		for (int i = 0; i < n; i++)
			for (int j = n-1; j >= 0; j--)
			{
				B[n - 1 - j][n - 1 - i] = A[i][j];
			}
	}
}