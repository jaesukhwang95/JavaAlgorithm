package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b1074 {

	public static int solve(int n, int x, int y) {
		if (n == 1) {
			return 2 * x + y;
		} else {
			int l = (int)Math.pow(2, n);
			if (x < l / 2 && y < l / 2) {
				return solve(n - 1, x, y);
			} else if (x < l / 2 && y >= l / 2) {
				return solve(n - 1, x, y - (int) Math.pow(2, n - 1)) + (int) Math.pow(2, 2 * n - 2);
			} else if (x >= l / 2 && y < l / 2) {
				return solve(n - 1, x - (int) Math.pow(2, n - 1), y) + 2 * (int) Math.pow(2, 2 * n - 2);
			} else {
				return solve(n - 1, x - (int) Math.pow(2, n - 1), y - (int) Math.pow(2, n - 1))
						+ 3 * (int) Math.pow(2, 2 * n - 2);
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		System.out.println(solve(n, r, c));
	}
}
