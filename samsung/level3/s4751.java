package baekjoon.samsung.level3;

import java.io.*;

public class s4751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			String str = br.readLine();
			StringBuilder[] line = new StringBuilder[6];
			for (int j = 0; j < 5; j++) {
				line[j] = new StringBuilder();
			}
			line[0].append("..#..");
			line[1].append(".#.#.");
			line[2].append("#.").append(str.charAt(0)).append(".#");
			line[3].append(".#.#.");
			line[4].append("..#..");
			if (str.length() > 1) {
				int k = 1;
				while (k != str.length()) {
					line[0].append(".#..");
					line[1].append("#.#.");
					line[2].append(".").append(str.charAt(k++)).append(".#");
					line[3].append("#.#.");
					line[4].append(".#..");
				}
			}
			for (int j = 0; j < 5; j++) {
				System.out.println(line[j]);
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
