package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b14442 {

	public static class Point {
		int x;
		int y;
		int wall;
		int dist;

		Point(int x, int y, int wall, int dist) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.dist = dist;
		}
	}

	public static int[] dx = { -1, 1, 0, 0, };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char[][] wall = new char[n][m];
		int[][] ans = new int[n][m];
		boolean[][][] visit = new boolean[n][m][k + 1];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++)
				wall[i][j] = str.charAt(j);
		}

		if (n == 1 && m == 1) {
			System.out.println(1);
			System.exit(0);
		}

		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0, 0, 0));
		visit[0][0][0] = true;
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				int z = p.wall;
				if (0 <= x && x < n && 0 <= y && y < m) {
					if (!visit[x][y][z]) {
						if (wall[x][y] == '0') {
							visit[x][y][z] = true;
							q.offer(new Point(x, y, p.wall, p.dist + 1));
							ans[x][y] = p.dist + 1;
							if (x == n - 1 && y == m - 1) {
								min = Math.min(min, ans[x][y]);
							}
						} else if (wall[x][y] == '1') {
							if (p.wall + 1 <= k) {
								visit[x][y][z] = true;
								q.offer(new Point(x, y, p.wall + 1, p.dist + 1));
								ans[x][y] = p.dist + 1;
								if (x == n - 1 && y == m - 1) {
									min = Math.min(min, ans[x][y]);
								}
							}
						}
					}
				}
			}
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min + 1);
		}
	}
}
