package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b12906 {

	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void makeGroup(int x, int y, int[][] arr, int idx, boolean[][] visit, int n, int m) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit[x][y] = true;
		q.offer(x);
		q.offer(y);
		arr[x][y] = idx;
		while (!q.isEmpty()) {
			int pollX = q.poll();
			int pollY = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = pollX + dx[i];
				int ny = pollY + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (!visit[nx][ny] && arr[nx][ny] == 1) {
						arr[nx][ny] = idx;
						visit[nx][ny] = true;
						q.offer(nx);
						q.offer(ny);
					}
				}
			}
		}
	}

	public static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int idx = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j] && arr[i][j] == 1) {
					makeGroup(i, j, arr, idx, visit, n, m);
					idx++;
				}
			}
		}
		int[] cnt = new int[idx];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cnt[arr[i][j]]++;
			}
		}
		cnt[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (arr[i][j] == 0) {
					int sum = 0;
					HashSet<Integer> set = new HashSet<Integer>();
					for (int k = 0; k < 4; k++) {
						if (0 <= i + dx[k] && i + dx[k] < n && 0 <= j + dy[k] && j + dy[k] < m) {
							set.add(arr[i + dx[k]][j + dy[k]]);
						}
					}
					for (int num : set) {
						sum = sum + cnt[num];
					}
					ans = Math.max(ans, sum + 1);
				}
		}
		System.out.println(ans);
	}
}