package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s6485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int[] arr = new int[5001];
			int num = Integer.parseInt(br.readLine());
			for (int j = 0; j < num; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				for (int k = start; k <= end; k++) {
					arr[k]++;
				}
			}
			sb.append("#").append(i + 1).append(" ");
			num = Integer.parseInt(br.readLine());
			for (int j = 0; j < num; j++) {
				sb.append(arr[Integer.parseInt(br.readLine())]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}