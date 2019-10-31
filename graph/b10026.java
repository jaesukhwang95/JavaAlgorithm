package baekjoon.graph;

import java.io.*;

public class b10026 {

	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static int[][] cnt;
	public static char[][] arr;
	public static int count;

	public static void color(int x, int y, int n) {
		if (cnt[x][y] != -1)
			return;
		cnt[x][y] = count;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (arr[nx][ny] == arr[x][y]) {
					color(nx, ny, n);
				}
			}
		}
	}

	public static void noColor(int x, int y, int n) {
		if (cnt[x][y] != -1)
			return;
		cnt[x][y] = count;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (arr[x][y] == 'R') {
					if (arr[nx][ny] == 'R' || arr[nx][ny] == 'G') {
						noColor(nx, ny, n);
					}
				} else if (arr[x][y] == 'G') {
					if (arr[nx][ny] == 'R' || arr[nx][ny] == 'G') {
						noColor(nx, ny, n);
					}
				} else if (arr[x][y] == 'B') {
					if (arr[nx][ny] == 'B') {
						noColor(nx, ny, n);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] ans = new int[2];
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		count = 1;
		cnt = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cnt[i][j] = -1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (cnt[i][j] == -1) {
					color(i, j, n);
					count++;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, cnt[i][j]);
			}
		}
		ans[0] = max;
		count = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cnt[i][j] = -1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (cnt[i][j] == -1) {
					noColor(i, j, n);
					count++;
				}
			}
		}
		max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, cnt[i][j]);
			}
		}
		ans[1] = max;

		System.out.print(ans[0] + " " + ans[1]);
		System.out.println();

	}
}