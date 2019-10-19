package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s3142 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int unicon = 0;
			for (int i = 0; i <= m; i++) {
				if (i * 2 + (m - i) * 1 == n) {
					unicon = i;
					break;
				}
			}
			int twinhon = m - unicon;
			sb.append("#").append(num + 1).append(" ").append(twinhon).append(" ").append(unicon).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}