package baekjoon.recursion;

import java.io.*;

public class b2448 {

	public static void solve(int n, int x, int y, char[][] arr) {
		if (n == 3) {
			arr[x][y] = '*';
			arr[x + 1][y - 1] = '*';
			arr[x + 1][y + 1] = '*';
			arr[x + 2][y - 2] = '*';
			arr[x + 2][y - 1] = '*';
			arr[x + 2][y] = '*';
			arr[x + 2][y + 1] = '*';
			arr[x + 2][y + 2] = '*';
		} else {
			solve(n / 2, x, y, arr);
			solve(n / 2, x + n / 2, y - n / 2, arr);
			solve(n / 2, x + n / 2, y + n / 2, arr);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][2 * n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 2 * n; j++) {
				if (j == 2 * n - 1)
					arr[i][j] = '\n';
				else
					arr[i][j] = ' ';
			}
		solve(n, 0, n - 1, arr);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 2 * n; j++) {
				sb.append(arr[i][j]);
			}
		bw.write(sb.toString());
		bw.close();
	}
}
