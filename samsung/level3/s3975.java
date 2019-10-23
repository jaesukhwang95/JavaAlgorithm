package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s3975 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			String ans = "";
			if (a * d == b * c) {
				ans = "DRAW";
			} else if (a * d > b * c) {
				ans = "ALICE";
			} else if (a * d < b * c) {
				ans = "BOB";
			}
			sb.append("#").append(num + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}