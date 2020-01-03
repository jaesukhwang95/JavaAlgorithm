package baekjoon.math;

import java.util.*;
import java.io.*;

public class b1016 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		boolean[] visit = new boolean[(int) (max - min) + 1];
		for (long i = 2; i * i <= max; i++) {
			long start = min + (i * i - (min % (i * i))) % (i * i);
			for (long j = start; j <= max; j = j + i * i) {
				visit[(int) (j - min)] = true;
			}
		}
		int ans = 0;
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
