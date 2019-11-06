package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class b1080 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] start = new int[n][m];
		int[][] end = new int[n][m];
		boolean[][] check = new boolean[n][m];
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				start[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				end[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (start[i][j] != end[i][j])
					check[i][j] = true;
			}
		}

		boolean signal = true;
		if (n <= 2 || m <= 2) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (check[i][j])
						signal = false;
				}
			}

			if (!signal)
				System.out.println(-1);
			else
				System.out.println(0);
			System.exit(0);
		}

		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				if (check[i][j]) {
					for (int k = i; k < i + 3; k++)
						for (int l = j; l < j + 3; l++) {
							if (check[k][l])
								check[k][l] = false;
							else
								check[k][l] = true;
						}
					cnt++;
				}
			}
		}

		signal = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check[i][j])
					signal = false;
			}
		}

		if (!signal)
			System.out.println(-1);
		else
			System.out.println(cnt);

	}
}
