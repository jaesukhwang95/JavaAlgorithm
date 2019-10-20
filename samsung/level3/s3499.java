package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s3499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] arr = new String[n];
			for (int j = 0; j < n; j++) {
				arr[j] = st.nextToken();
			}
			StringBuilder ans = new StringBuilder();
			if (n % 2 == 0) {
				for (int j = 0; j < n / 2; j++) {
					ans.append(arr[j]).append(" ");
					ans.append(arr[n / 2 + j]).append(" ");
				}
			} else {
				for (int j = 0; j < n / 2; j++) {
					ans.append(arr[j]).append(" ");
					ans.append(arr[n / 2 + 1 + j]).append(" ");
				}
				ans.append(arr[n / 2]);
			}
			sb.append("#").append(i + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
