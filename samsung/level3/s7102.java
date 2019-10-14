package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s7102 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringBuilder ans = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] cnt = new int[n + m + 1];
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= m; k++) {
					cnt[j + k]++;
				}
			}
			int max = Integer.MIN_VALUE;
			int idx = 0;
			for (int j = 2; j <= n + m; j++) {
				if (max < cnt[j]) {
					idx = j;
					max = cnt[j];
				}
			}
			ans.append(idx);
			while (idx < n + m && cnt[idx] == cnt[idx + 1]) {
				idx++;
				ans.append(" ").append(idx);
			}
			sb.append("#").append(i + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
