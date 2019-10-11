package baekjoon.dynamicProgramming;

import java.util.*;
import java.io.*;

public class b10942 {

	public static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		check = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++)
			check[i][i] = true;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1])
				check[i][i + 1] = true;
		}

		for (int k = 0; k < n - 2; k++) {
			for (int i = 0; i < n - 2 - k; i++) {
				if (arr[i] == arr[i + 2 + k] && check[i + 1][i + 1 + k])
					check[i][i + 2 + k] = true;
			}
		}
		int num = Integer.parseInt(br.readLine());
		while (num-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			if (check[start][end])
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
