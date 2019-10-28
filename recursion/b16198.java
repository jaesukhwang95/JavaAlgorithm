package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b16198 {

	public static void go(int idx, boolean[] visit, int sum, int[] arr, int n) {
		if (idx == n - 2) {
			if (sum > max)
				max = sum;
			return;
		}
		for (int i = 1; i < n - 1; i++) {
			if (!visit[i]) {
				int j = i - 1;
				int k = i + 1;
				visit[i] = true;
				while (true) {
					if (j == 0)
						break;
					if (!visit[j]) {
						break;
					}
					j--;
				}
				while (true) {
					if (k == n - 1)
						break;
					if (!visit[k]) {
						break;
					}
					k++;
				}
				go(idx + 1, visit, sum + arr[j] * arr[k], arr, n);
				visit[i] = false;
			}
		}
	}

	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] visit = new boolean[n];
		go(0, visit, 0, arr, n);
		System.out.println(max);
	}
}
