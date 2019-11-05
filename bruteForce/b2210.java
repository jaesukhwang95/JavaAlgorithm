package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b2210 {

	public static HashSet<Integer> set = new HashSet<Integer>();
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int[][] arr = new int[5][5];
	public static int cnt = 0;

	public static void go(int idx, int sum, int x, int y) {
		if (idx == 6) {
			if (!set.contains(sum)) {
				set.add(sum);
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
				go(idx + 1, sum * 10 + arr[nx][ny], nx, ny);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				go(0, 0, i, j);
			}
		}
		System.out.println(set.size());
	}
}
