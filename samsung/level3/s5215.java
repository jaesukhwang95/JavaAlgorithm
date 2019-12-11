package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s5215 {

	public static void chooseHamburger(int idx, int[] scores, int[] calories, int caloryLimit, int n, int score,
			int calory) {
		if (caloryLimit < calory) {
			return;
		}
		if (idx == n) {
			totalScore = Math.max(totalScore, score);
			return;
		}
		chooseHamburger(idx + 1, scores, calories, caloryLimit, n, score + scores[idx], calory + calories[idx]);
		chooseHamburger(idx + 1, scores, calories, caloryLimit, n, score, calory);
	}
	
	public static int totalScore = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int caloryLimit = Integer.parseInt(st.nextToken());
			int[] scores = new int[n];
			int[] calories = new int[n];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				scores[j] = Integer.parseInt(st.nextToken());
				calories[j] = Integer.parseInt(st.nextToken());
			}
			totalScore = 0;
			chooseHamburger(0, scores, calories, caloryLimit, n, 0, 0);
			sb.append("#").append(i).append(" ").append(totalScore).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
