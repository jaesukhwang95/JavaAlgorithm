package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s5431 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			StringBuilder ans = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			boolean[] arr = new boolean[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				int idx = Integer.parseInt(st.nextToken());
				arr[idx] = true;
			}
			for (int j = 1; j <= n; j++) {
				if (!arr[j])
					ans.append(j).append(" ");
			}
			sb.append("#").append(i).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
