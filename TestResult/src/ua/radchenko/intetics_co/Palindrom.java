package ua.radchenko.intetics_co;

public class Palindrom {
	static int  iterat = 0;
	public static void main(String[] args) {
		int a = 999;
		int a2 = 0;
		int b = 100;
		

		long time1 = System.currentTimeMillis();

		for (int i = a; i > b; i--) {
			iterat++;
			if (i == a) {
				a2 = a;
			}
			String rev = new StringBuffer(String.valueOf(a2)).reverse()
					.toString();
			int c = Integer.parseInt(String.valueOf(a2) + rev);
			if (isPalindrom(c)) {
				rezults(a, b, c);
				if (rezults(a, b, c)) {
					break;
				}
			}
			a2--;
		}
		System.out.println("the number of loop iterations :"+ iterat);
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time1 + "(millis)");

	}

	public static boolean rezults(int a1, int b2, int c2) {
		for (int i = a1; a1 > b2; i--) {
			iterat++;
			if (c2 % i == 0 && i >= b2) {
				int rezult = c2 / i;
				if (rezult <= a1) {
					System.out.println(i + "*" + rezult + "=" + c2);
					return true;
				}
			}
			if (i == b2) {
				break;
			}
		}
		return false;
	}

	public static boolean isPalindrom(int i) {									
		String a = String.valueOf(i);
		StringBuffer b = new StringBuffer(a);
		StringBuffer m = b.reverse();
		boolean d = a.equals(m.toString());
		return d;
	}

}
