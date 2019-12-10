package baekjoon.samsung.level3;

import java.io.*;

public class s5603 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int ans = 0;
			int num = Integer.parseInt(br.readLine());
			int[] arr = new int[num];
			int sum = 0;
			for (int j = 0; j < num; j++) {
				arr[j] = Integer.parseInt(br.readLine());
				sum = sum + arr[j];
			}
			int avg = sum / num;
			for (int j = 0; j < num; j++) {
				if (avg > arr[j]) {
					ans = ans + avg - arr[j];
				}
			}
			sb.append("#").append(i + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}