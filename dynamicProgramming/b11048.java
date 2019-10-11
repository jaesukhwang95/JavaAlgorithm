package baekjoon.dynamicProgramming;

import java.util.*;
import java.io.*;

public class b11048 {

	public static int[][] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		d = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		d[0][0] = arr[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0)
					continue;
				else if (j == 0)
					d[i][j] = d[i - 1][j] + arr[i][j];
				else if (i == 0)
					d[i][j] = d[i][j - 1] + arr[i][j];
				else
					d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]) + arr[i][j];
			}
		}
		System.out.println(d[n - 1][m - 1]);
	}
}
