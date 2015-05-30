package ua.radchenko.sloboda.sumfactorial;

import java.util.Scanner;


public class MainTestSummFactorial {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int n = 0;
		boolean chek = true;
		SummFactorial fact = new SummFactorial();
		System.out
				.println("Enter a positive:");
		do {
			Scanner scanner = new Scanner(System.in);
			String a = scanner.nextLine();
			n = Integer.parseInt(a);
			if (n > 0 && n != 0) {
				chek = false;
			} else {
				System.out.println("Enter a positive number greater than zero");
			}
		} while (chek);

		System.out.println("fact= " + fact.factr(n));
		System.out.println("summfactr = " + fact.summfactr(n));

	}
}
