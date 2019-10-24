package baekjoon.dynamicProgramming;

import java.io.*;

public class b15989 {

	public static int[] d1 = new int[10001];
	public static int[] d2 = new int[10001];
	public static int[] d3 = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		d1[1] = 1;
		for (int i = 2; i <= 10000; i++) {
			d1[i] = d1[i - 1];
		}
		d2[2] = 1;
		for (int i = 3; i <= 10000; i++) {
			d2[i] = d2[i - 2] + d1[i - 2];
		}
		d3[3] = 1;
		for (int i = 4; i <= 10000; i++) {
			d3[i] = d3[i - 3] + d2[i - 3] + d1[i - 3];
		}
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			int k = Integer.parseInt(br.readLine());
			sb.append(d1[k] + d2[k] + d3[k]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
