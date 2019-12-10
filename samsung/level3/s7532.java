package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s7532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int ans = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int s = 1;
			int e = 1;
			int m = 1;
			while (S != s || E != e || M != m) {
				s = s + 1;
				if (s == 366)
					s = 1;
				e = e + 1;
				if (e == 25)
					e = 1;
				m = m + 1;
				if (m == 30)
					m = 1;
				ans++;
			}
			sb.append("#").append(i + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}