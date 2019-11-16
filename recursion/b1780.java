package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b1780 {

	public static boolean sameNum(int x, int y, int len, int[][] arr) {
		int comp = arr[x][y];
		for (int i = x; i < x + len; i++)
			for (int j = y; j < y + len; j++)
				if (comp != arr[i][j])
					return false;
		return true;
	}

	public static void solve(int[][] arr, int len, int[] cnt, int x, int y) {
		if (sameNum(x, y, len, arr)) {
			cnt[arr[x][y] + 1]++;
		} else {
			for (int i = x; i < x + len; i = i + len / 3)
				for (int j = y; j < y + len; j = j + len / 3) {
					solve(arr, len / 3, cnt, i, j);
				}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[] cnt = new int[3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		solve(arr, n, cnt, 0, 0);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cnt[2]);
	}
}
