package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s5948 {

	public static HashSet<Integer> set;
	public static void dfs(int idx, int start, int sum, int[] arr) {
		if (idx == 3) {
			set.add(sum);
			return;
		}
		for (int i = start; i < 7; i++) {
			dfs(idx + 1, i + 1, sum + arr[i], arr);
		}
	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[7];
			for (int i = 0; i < 7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			set = new HashSet<Integer>();
			dfs(0, 0, 0, arr);
			ArrayList<Integer> ans = new ArrayList<Integer>(set);
			Collections.sort(ans);
			sb.append("#").append(num + 1).append(" ").append(ans.get(ans.size() - 5)).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
