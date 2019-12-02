package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b17086 {

	public static int[] dx = { 1, 1, -1, -1, 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 1, -1, 1, -1, 0, 0 };
	public static int safeDistance = Integer.MIN_VALUE;

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs(int i, int j, int n, int m, ArrayList<Pair> shark) {
		Queue<Pair> q = new LinkedList<Pair>();
		boolean[][] visit = new boolean[n][m];
		int[][] distance = new int[n][m];
		visit[i][j] = true;
		q.offer(new Pair(i, j));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int a = 0; a < 8; a++) {
				int nx = x + dx[a];
				int ny = y + dy[a];
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (!visit[nx][ny]) {
						distance[nx][ny] = distance[x][y] + 1;
						visit[nx][ny] = true;
						q.offer(new Pair(nx, ny));
					}
				}
			}
		}
		int localMimimum = Integer.MAX_VALUE;
		for (Pair p : shark) {
			int newDistance = Math.abs(distance[p.x][p.y] - distance[i][j]);
			localMimimum = Math.min(localMimimum, newDistance);
		}
		safeDistance = Math.max(localMimimum, safeDistance);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] space = new int[n][m];
		ArrayList<Pair> shark = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			{
				for (int j = 0; j < m; j++) {
					space[i][j] = Integer.parseInt(st.nextToken());
					if (space[i][j] == 1) {
						shark.add(new Pair(i, j));
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bfs(i, j, n, m, shark);
			}
		}
		System.out.println(safeDistance);
	}
}
