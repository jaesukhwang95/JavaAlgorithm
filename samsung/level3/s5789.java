package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s5789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int num = 1;
			for (int j = 0; j < q; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				for (int k = start - 1; k < end; k++) {
					arr[k] = num;
				}
				num++;
			}

			sb.append("#").append(i).append(" ");
			for (int j = 0; j < n; j++) {
				sb.append(arr[j] + " ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
