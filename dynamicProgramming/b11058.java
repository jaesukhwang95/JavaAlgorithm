package baekjoon.dynamicProgramming;

import java.util.*;

public class b11058 {

	public static long[] d = new long[101];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= 100; i++) {
			d[i] = i;
		}
		for (int i = 4; i <= 100; i++) {
			int j = 3;
			while (true) {
				if ((i - j) == 0)
					break;
				d[i] = Math.max(d[i], d[i - j] * (j - 1));
				j++;
			}
		}
		System.out.println(d[n]);
		sc.close();
	}
}