package baekjoon.samsung.level3;

import java.io.*;

public class s7510 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int j = 1; j <= num / 2; j++) {
				int sum = 0;
				int it = j;
				while (sum < num) {
					sum += it;
					it++;
				}
				if (sum == num) {
					cnt++;
				}
			}
			sb.append("#").append(i + 1).append(" ").append(cnt + 1).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
