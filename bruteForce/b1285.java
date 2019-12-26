package baekjoon.bruteForce;

import java.io.*;

public class b1285 {

	public static void flipRow(char[][] coin, int num, int n) {
		for (int i = 0; i < n; i++) {
			if (coin[num][i] == 'T')
				coin[num][i] = 'H';
			else
				coin[num][i] = 'T';
		}
	}

	public static void getMinimum(int idx, int n, char[][] coin) {
		if (idx == n) {
			int sum = 0;

			for (int i = 0; i < n; i++) {
				int localMin = 0;
				for (int j = 0; j < n; j++) {
					if (coin[j][i] == 'T')
						localMin++;
				}
				localMin = Math.min(localMin, n - localMin);
				sum = sum + localMin;
			}
			if (ans > sum) {
				ans = sum;
			}
			return;
		}
		flipRow(coin, idx, n);
		getMinimum(idx + 1, n, coin);
		flipRow(coin, idx, n);
		getMinimum(idx + 1, n, coin);
	}

	public static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] coin = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++)
				coin[i][j] = str.charAt(j);
		}
		getMinimum(0, n, coin);
		System.out.println(ans);
	}
}