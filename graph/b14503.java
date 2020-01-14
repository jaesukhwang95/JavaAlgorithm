package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b14503 {

	public static class Pair {
		int x;
		int y;
		int direction;

		Pair(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}

	public static Pair changeDirection(int r, int c, int dir, int[][] space, boolean[][] visit, int n, int m) {
		for (int i = 0; i < 4; i++) {
			dir = (4 + dir - 1) % 4;
			if (dir == 0) {
				if (r - 1 >= 0 && !visit[r - 1][c] && space[r - 1][c] == 0)
					return new Pair(r - 1, c, 0);
			} else if (dir == 1) {
				if (c + 1 < m && !visit[r][c + 1] && space[r][c + 1] == 0)
					return new Pair(r, c + 1, 1);
			} else if (dir == 2) {
				if (r + 1 < n && !visit[r + 1][c] && space[r + 1][c] == 0)
					return new Pair(r + 1, c, 2);
			} else if (dir == 3) {
				if (c - 1 >= 0 && !visit[r][c - 1] && space[r][c - 1] == 0)
					return new Pair(r, c - 1, 3);
			}
		}
		if ((dir + 2) % 4 == 0) {
			if (r - 1 >= 0 && space[r - 1][c] == 0) {
				visit[r - 1][c] = true;
				return new Pair(r - 1, c, dir);

			}
		} else if ((dir + 2) % 4 == 1) {
			if (c + 1 < m && space[r][c + 1] == 0) {
				visit[r][c + 1] = true;
				return new Pair(r, c + 1, dir);
			}
		} else if ((dir + 2) % 4 == 2) {
			if (r + 1 < n && space[r + 1][c] == 0) {
				visit[r + 1][c] = true;
				return new Pair(r + 1, c, dir);

			}
		} else if ((dir + 2) % 4 == 3) {
			if (c - 1 >= 0 && space[r][c - 1] == 0) {
				visit[r][c - 1] = true;
				return new Pair(r, c - 1, dir);
			}
		}
		return new Pair(-1, -1, -1);
	}

	public static void clean(int r, int c, int firstDirection, int[][] space, boolean[][] visit, int n, int m) {
		Queue<Pair> q = new LinkedList<Pair>();
		visit[r][c] = true;
		q.offer(new Pair(r, c, firstDirection));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			int direction = p.direction;
			Pair nextPair = changeDirection(x, y, direction, space, visit, n, m);
			if (nextPair.direction == -1)
				break;
			else {
				q.offer(nextPair);
				visit[nextPair.x][nextPair.y] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		int[][] space = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] visit = new boolean[n][m];
		clean(r, c, dir, space, visit, n, m);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j])
					ans++;
			}
		}
		System.out.println(ans);
	}
}
