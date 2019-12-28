package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

public class b11060 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] space = new int[n];
		for (int i = 0; i < n; i++) {
			space[i] = Integer.parseInt(st.nextToken());
		}
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		ans[0] = 0;

		for (int i = 0; i < n; i++) {
			if (ans[i] != Integer.MAX_VALUE) {
				for (int j = 1; j <= space[i]; j++) {
					if (i + j < n) {
						ans[i + j] = Math.min(ans[i] + 1, ans[i + j]);
					}
				}
			}
		}
		if (ans[n - 1] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans[n - 1]);
	}
}
