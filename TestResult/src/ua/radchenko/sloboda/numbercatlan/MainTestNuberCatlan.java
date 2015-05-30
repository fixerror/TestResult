package ua.radchenko.sloboda.numbercatlan;

import java.util.Scanner;

public class MainTestNuberCatlan {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int n = 0;
		boolean chek = true;
		Catalan cat = new Catalan();
		System.out
				.println("Enter a positive number for counting the number of Catalano from 1...n:");
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

		for (int i = 1; i <= n; i++) {
				System.out.println("n=" + i + "  Cn= " + cat.catalan(i));

		}

	}
}
