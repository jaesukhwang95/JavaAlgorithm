package baekjoon.samsung.level3;

import java.io.*;

public class s5986 {

	public static int[] prime = new int[169];
	public static boolean[] check = new boolean[1010];

	public static void makePrime(int num) {
		for (int i = 2; i <= num; i++) {
			if (!check[i]) {
				for (int j = i * 2; j <= num; j = j + i) {
					check[j] = true;
				}
			}
		}
		int k = 0;
		for (int i = 2; i <= num; i++) {
			if (!check[i])
				prime[k++] = i;
		}
	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		makePrime(1009);
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			int N = Integer.parseInt(br.readLine());
			int endIdx = 0;
			while (true) {
				if (prime[endIdx++] > N)
					break;
			}
			endIdx = endIdx - 2;
			int cnt = 0;
			for (int i = 0; i < endIdx; i++) {
				for (int j = i; j < endIdx; j++) {
					for (int k = j; k < endIdx; k++) {
						if (prime[i] + prime[j] + prime[k] == N) {
							cnt++;
						}
						if (prime[i] + prime[j] + prime[k] > N)
							break;
					}
					if (prime[i] + 2 * prime[j] > N)
						break;
				}
				if (3 * prime[i] > N)
					break;
			}
			sb.append("#").append(num + 1).append(" ").append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}