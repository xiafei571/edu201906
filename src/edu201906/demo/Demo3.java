package edu201906.demo;

public class Demo3 {

	public static void main(String[] args) {
		for (int n = 0; n < 4; n++) {
			for (int m = 0; m < 6; m++) {
				System.out.println(n + "," + m + "," + calcT(n, m));
			}
		}
	}

	private static int[] C = { 1, 2, 4, 7 };

	private static int calcT(int n, int m) {
		if (n < 0 || m <= 0)
			return 0;

		int sum = 0;

		if (m >= C[n]) {
			sum = m / C[n];
			if (m % C[n] > 0) {
				sum += calcT(n - 1, m % C[n]);
			}
		} else {
			return calcT(n - 1, m);
		}

		return sum;
	}

	/*
	 * n m T 0,0,0 0,1,1 0,2,2 0,3,3 0,4,4 0,5,5 1,0,0 1,1,1 1,2,1 1,3,2 1,4,2 1,5,3
	 * 2,0,0 2,1,1 2,2,1 2,3,2 2,4,1 2,5,2 3,0,0 3,1,1 3,2,1 3,3,2 3,4,1 3,5,2
	 */
}
