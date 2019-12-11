package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s4299 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int eleven = 16511;
			int day = Integer.parseInt(st.nextToken());
			int hour = Integer.parseInt(st.nextToken());
			int minute = Integer.parseInt(st.nextToken());
			ans = (day * 24 * 60 + hour * 60 + minute) - eleven;
			if (ans < 0)
				ans = -1;
			sb.append("#").append(i).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}