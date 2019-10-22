package baekjoon.samsung.level3;

import java.io.*;

public class s3131 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] prime = new boolean[1000001];
		for (int i = 2; i <= 1000000; i++) {
			if (!prime[i]) {
				for (int j = 2 * i; j <= 1000000; j = j + i)
					prime[j] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= 1000000; i++) {
			if (!prime[i]) {
				sb.append(i + " ");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("\n");
		bw.write(sb.toString());
		bw.close();
	}
}
