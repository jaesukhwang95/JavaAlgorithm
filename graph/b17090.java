package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b17090 {

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void checkMargin(char[][] maze, int n, int m, Queue<Pair> q, boolean[][] visit) {
		for (int i = 0; i < n; i++) {
			if (maze[i][0] == 'L') {
				q.offer(new Pair(i, 0));
				visit[i][0] = true;
			}
			if (maze[i][m - 1] == 'R') {
				q.offer(new Pair(i, m - 1));
				visit[i][m - 1] = true;
			}
		}
		for (int i = 0; i < m; i++) {
			if (maze[0][i] == 'U') {
				q.offer(new Pair(0, i));
				visit[0][i] = true;

			}
			if (maze[n - 1][i] == 'D') {
				q.offer(new Pair(n - 1, i));
				visit[n - 1][i] = true;
			}
		}
	}

	public static int count(char[][] maze, int n, int m, Queue<Pair> q, boolean[][] visit) {
		int cnt = q.size();
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && !visit[nx][ny]) {
					if (i == 0 && maze[nx][ny] == 'D') {
						q.offer(new Pair(nx, ny));
						visit[nx][ny] = true;
						cnt++;
					} else if (i == 1 && maze[nx][ny] == 'U') {
						q.offer(new Pair(nx, ny));
						visit[nx][ny] = true;
						cnt++;
					} else if (i == 2 && maze[nx][ny] == 'R') {
						q.offer(new Pair(nx, ny));
						visit[nx][ny] = true;
						cnt++;
					} else if (i == 3 && maze[nx][ny] == 'L') {
						q.offer(new Pair(nx, ny));
						visit[nx][ny] = true;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] maze = new char[n][m];
		boolean[][] visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = str.charAt(j);
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		checkMargin(maze, n, m, q, visit);
		int ans = count(maze, n, m, q, visit);
		System.out.println(ans);
	}
}
