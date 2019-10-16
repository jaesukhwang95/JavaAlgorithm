package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s4676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringBuilder ans = new StringBuilder();
			String str = br.readLine();
			int n = Integer.parseInt(br.readLine());
			int[] cnt = new int[str.length()+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				cnt[Integer.parseInt(st.nextToken())]++;
			}
			for (int k = 0; k < cnt[0]; k++)
				ans.append("-");
			for (int j = 0; j < str.length(); j++) {
				ans.append(str.charAt(j));
				for (int k = 0; k < cnt[j + 1]; k++) {
					ans.append("-");
				}
			}
			sb.append("#").append(i + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}