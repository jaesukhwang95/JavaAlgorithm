package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

//n:곡수, s:시작볼륨, m:최대볼륨 

public class b1495 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] v = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		boolean[][] d = new boolean[n + 1][m + 1];
		d[0][s] = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= m; j++) {
				if (!d[i][j])
					continue;
				if (j + v[i + 1] <= m)
					d[i + 1][j + v[i + 1]] = true;
				if (j - v[i + 1] >= 0)
					d[i + 1][j - v[i + 1]] = true;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= m; i++) {
			if (d[n][i]) {
				max = Math.max(max, i);
			}
		}

		if (max == Integer.MIN_VALUE)
			System.out.println(-1);
		else
			System.out.println(max);
		br.close();
	}
}
