package ua.radchenko.sloboda.sumfactorial;

import java.math.BigInteger;

public class SummFactorial {

	public BigInteger factr(long n) {
		BigInteger result = BigInteger.ONE;
		for (long i = 2; i <= n; i++)
			result = result.multiply(BigInteger.valueOf(i));
		return result;
	}

	public long summfactr(int n) {

		SummFactorial fact = new SummFactorial();

		BigInteger rez = fact.factr(n);
		String str = rez.toString(10);
		int rezult = 0;
		int i, len = str.length();
		int arr[] = new int[len];
		for (i = 0; i < len; ++i) {
			arr[i] = Integer.parseInt(str.charAt(i) + "");
				rezult += arr[i];
		//	System.out.println(arr[i]);
		}

		return rezult;

	}

}