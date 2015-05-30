package ua.radchenko.sloboda.numbercatlan;

public class Catalan {

	private int[] cn;
	public int catalan(int n) {
		cn = new int[n + 1];
		// Create array to store cn[]
		cn[0] = 1;
		for (int i = 1; i <= n; ++i) { // Compute cn[i] for 1...n
			cn[i] = 0;
			for (int y = 0; y < n; ++y) { // Compute nunbers catalan
				if ((i - 1 - y) != -1) { // check (i-1-y)!=-1
					cn[i] += cn[y] * cn[Math.abs(i - 1 - y)];
				}
			}
		}
		return cn[n];
	}

}
