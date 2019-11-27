package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b2422 {

	public static int cnt = 0;

	public static void chooseIcecream(int[] indexList, int n, int r, int index, int target) {
		if (r == 0) {
			int[] number = new int[3];
			int k = 0;
			for (int i : indexList) {
				number[k++] = (i + 1);
			}
			boolean signal = false;
			for (int i = 0; i < 2; i++) {
				for (int j = i + 1; j < 3; j++) {
					if (tasteless[number[i]][number[j]]) {
						signal = true;
						break;
					}
				}
			}
			if (!signal)
				cnt++;
			return;
		}
		if (target == n)
			return;
		indexList[index] = target;
		chooseIcecream(indexList, n, r - 1, index + 1, target + 1);
		chooseIcecream(indexList, n, r, index, target + 1);
	}

	public static boolean[][] tasteless = new boolean[201][201];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			tasteless[x][y] = true;
			tasteless[y][x] = true;
		}
		int[] indexList = new int[3];
		chooseIcecream(indexList, n, 3, 0, 0);
		System.out.println(cnt);
	}
}
