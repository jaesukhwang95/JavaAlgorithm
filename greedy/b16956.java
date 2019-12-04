package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class b16956 {

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean checkAdjacency(int x, int y, int n, int m, char[][] arr) {
		if (0 <= x - 1) {
			if (arr[x - 1][y] == 'S') {
				return true;
			}
		}
		if (x + 1 < n) {
			if (arr[x + 1][y] == 'S') {
				return true;
			}
		}
		if (0 <= y - 1) {
			if (arr[x][y - 1] == 'S') {
				return true;
			}
		}
		if (y + 1 < m) {
			if (arr[x][y + 1] == 'S') {
				return true;
			}
		}
		return false;
	}

	public static void installFence(int x, int y, int n, int m, char[][] arr) {
		if (0 <= x - 1) {
			if (arr[x - 1][y] == '.') {
				arr[x - 1][y] = 'D';
			}
		}
		if (x + 1 < n) {
			if (arr[x + 1][y] == '.') {
				arr[x + 1][y] = 'D';
			}
		}
		if (0 <= y - 1) {
			if (arr[x][y - 1] == '.') {
				arr[x][y - 1] = 'D';
			}
		}
		if (y + 1 < m) {
			if (arr[x][y + 1] == '.') {
				arr[x][y + 1] = 'D';
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n][m];
		ArrayList<Pair> wolf = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'W') {
					wolf.add(new Pair(i, j));
				}
			}
		}
		boolean signal = false;
		for (Pair w : wolf) {
			if (checkAdjacency(w.x, w.y, n, m, arr)) {
				signal = true;
			}
		}
		if (signal) {
			System.out.println(0);
		} else {
			for (Pair w : wolf)
				installFence(w.x, w.y, n, m, arr);
			System.out.println(1);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
