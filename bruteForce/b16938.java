package baekjoon.bruteForce;

import java.io.*;
import java.util.*;

public class b16938 {

	public static int[] arr;
	public static ArrayList<Integer> select;
	public static boolean[] visited;
	public static int cnt = 0;

	static void combination(int[] arr, boolean[] visited, int depth, int n, int idx, int l, int r, int x) {
		if (idx == 0) {
			Arrays.sort(arr);
			select = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				if (visited[i] == true) {
					select.add(arr[i]);
				}
			}
			int sum = 0;
			for (int i : select) {
				sum += i;
			}
			if (l <= sum && sum <= r && (select.get(select.size() - 1) - select.get(0)) >= x) {
				cnt++;
			}
			return;
		}
		if (depth == n) {
			return;
		} else {
			visited[depth] = true;
			combination(arr, visited, depth + 1, n, idx - 1, l, r, x);
			visited[depth] = false;
			combination(arr, visited, depth + 1, n, idx, l, r, x);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 2; i <= n; i++) {
			combination(arr, visited, 0, n, i, l, r, x);
		}
		System.out.println(cnt);
	}
}