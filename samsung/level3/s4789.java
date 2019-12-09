package baekjoon.samsung.level3;

import java.io.*;

public class s4789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int ans = 0;
			int sum = 0;
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if (sum < j && str.charAt(j) != '0') {
					ans = ans + j - sum;
					sum = sum + j - sum;
				}
				sum = sum + str.charAt(j) - '0';
			}
			sb.append("#").append(i).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
