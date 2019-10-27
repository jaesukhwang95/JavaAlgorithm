package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

//n: 총 숫자 갯수

public class b5557 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		long [][] d = new long [n + 1][21];
		d[1][num[1]] = 1;
		for (int i = 2; i < n; i++) {
			for (int j = 0; j <= 20; j++) {
				if (d[i - 1][j] > 0) {
					if (j + num[i] <= 20)
						d[i][j + num[i]] += d[i-1][j];
					if (j - num[i] >= 0)
						d[i][j - num[i]] += d[i-1][j];
				}
			}
		}
		long cnt = 0;
			cnt += d[n-1][num[n]];
		System.out.println(cnt);
		br.close();
	}
}
