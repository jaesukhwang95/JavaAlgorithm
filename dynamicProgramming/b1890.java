package baekjoon.dynamicProgramming;

import java.util.*;
import java.io.*;

public class b1890 {

	public static long[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		dist = new long[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		dist[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				for (int k = 0; k < j; k++) {
					if (arr[i][k] + k == j) {
						dist[i][j] += dist[i][k];
					}
				}
				for (int k = 0; k < i; k++) {
					if (arr[k][j] + k == i) {
						dist[i][j] += dist[k][j];
					}
				}
			}
		}
		System.out.println(dist[n - 1][n - 1]);

	}
}
