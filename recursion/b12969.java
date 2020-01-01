package baekjoon.recursion;

import java.io.*;
import java.util.*;

public class b12969 {
	public static boolean signal = false;
	public static String ans = "";

	public static void getString(int idx, int a, int b, int trueCase, int n, int k, boolean[][][][] visit,
			StringBuilder sb) {
		if (idx == n) {
			if (trueCase == k) {
				signal = true;
				ans = sb.toString();
				return;
			}
		}
		if (idx < n && !visit[idx][a][b][trueCase]) {
			visit[idx][a][b][trueCase] = true;
			sb.append('A');
			getString(idx + 1, a + 1, b, trueCase, n, k, visit, sb);
			sb.delete(sb.length() - 1, sb.length());
			sb.append('B');
			getString(idx + 1, a, b + 1, trueCase + a, n, k, visit, sb);
			sb.delete(sb.length() - 1, sb.length());
			sb.append('C');
			getString(idx + 1, a, b, trueCase + a + b, n, k, visit, sb);
			sb.delete(sb.length() - 1, sb.length());
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[][][][] visit = new boolean[n + 1][n + 1][n + 1][n * (n - 1) / 2 + 1];
		StringBuilder sb = new StringBuilder();
		getString(0, 0, 0, 0, n, k, visit, sb);
		if (signal) {
			System.out.println(ans.toString());
		} else {
			System.out.println(-1);
		}
	}
}
