package baekjoon.dynamicProgramming;

import java.io.*;

public class b10422 {

	public static void main(String[] args) throws IOException {
		long[] d = new long[5001];

		d[0] = 1;
		d[2] = 1;

		for (int l = 4; l <= 5000; l = l + 2) {
			for (int i = 2; i <= l; i = i + 2) {

				d[l] += d[i - 2] * d[l - i];
				d[l] = d[l] % 1000000007L;

			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int k = Integer.parseInt(br.readLine());
			System.out.println(d[k]);
		}
		br.close();
	}
}
