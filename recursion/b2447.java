package baekjoon.recursion;

import java.io.*;

public class b2447 {

	public static char[][] arr;

	public static void solve(int n, int x, int y) {
		if (n == 1)
			arr[x][y] = '*';
		else {
			int num = n / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1) {
						for (int k = x + num; k < x + 2 * num; k++) {
							for (int l = y + num; l < y + 2 * num; l++) {
								arr[k][l] = ' ';
							}
						}
					} else {
						solve(num, x + i * num, y + j * num);
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		solve(n, 0, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
}
