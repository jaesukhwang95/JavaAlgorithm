package baekjoon.samsung.level3;

import java.io.*;

public class s1216 {

	public static boolean[][] p;
	public static char[][] arr = new char[101][101];

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int num = 0; num < 10; num++) {
			br.readLine();
			int max = 1;
			for (int i = 1; i <= 100; i++) {
				String str = br.readLine();
				for (int j = 1; j <= 100; j++)
					arr[i][j] = str.charAt(j - 1);
			}

			for (int j = 1; j <= 100; j++) {
				p = new boolean[101][101];
				for (int i = 1; i <= 100; i++) {
					p[i][i] = true;
				}
				for (int i = 1; i <= 99; i++) {
					if (arr[i][j] == arr[i + 1][j]) {
						if (max < 2)
							max = 2;
						p[i][i + 1] = true;
					}
				}
				for (int k = 1; k < 99; k++) {
					for (int i = 1; i <= 99 - k; i++) {
						if (p[i + 1][i + k] && arr[i][j] == arr[i + k + 1][j]) {
							if (max < k + 2)
								max = k + 2;
							p[i][i + k + 1] = true;
						}
					}
				}
			}

			for (int j = 1; j <= 100; j++) {
				p = new boolean[101][101];
				for (int i = 1; i <= 100; i++) {
					p[i][i] = true;
				}
				for (int i = 1; i <= 99; i++) {
					if (arr[j][i] == arr[j][i + 1]) {
						if (max < 2)
							max = 2;
						p[i][i + 1] = true;
					}
				}
				for (int k = 1; k < 99; k++) {
					for (int i = 1; i <= 99 - k; i++) {
						if (p[i + 1][i + k] && arr[j][i] == arr[j][i + k + 1]) {
							if (max < k + 2)
								max = k + 2;
							p[i][i + k + 1] = true;
						}
					}
				}
			}

			sb.append("#").append(num + 1).append(" ").append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
