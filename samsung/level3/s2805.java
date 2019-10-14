package baekjoon.samsung.level3;

import java.io.*;

public class s2805 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			int sum = 0;
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			for (int i = 0; i < n / 2; i++) {
				int start = (n - 1) / 2 - i;
				int end = (n - 1) / 2 + i;
				for (int j = start; j <= end; j++) {
					sum += arr[i][j];
				}
			}
			for (int i = 0; i < n; i++) {
				sum += arr[(n - 1) / 2][i];
			}
			for (int i = (n + 1) / 2; i < n; i++) {
				int k = (n - 1) - i;
				int start = (n - 1) / 2 - k;
				int end = (n - 1) / 2 + k;
				for (int j = start; j <= end; j++) {
					sum += arr[i][j];
				}
			}
			sb.append("#").append(num + 1).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
