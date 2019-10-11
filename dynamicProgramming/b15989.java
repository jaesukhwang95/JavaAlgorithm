package baekjoon.dynamicProgramming;

import java.io.*;

public class b15989 {

	public static int[][] d = new int[2][10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		d[0][2] = 1;
		for (int i = 3; i < 10001; i++) {
			d[0][i] = d[0][i - 2] + 1;
			d[1][i] = d[1][i - 3] + d[0][i - 3] + 1;
		}
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			int k = Integer.parseInt(br.readLine());
			sb.append(d[0][k] + d[1][k] + 1).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
