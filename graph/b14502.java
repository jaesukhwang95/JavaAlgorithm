package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b14502 {

	public static class pair {
		int x;
		int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static ArrayList<pair> virus = new ArrayList<pair>();
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		boolean[][] visit = new boolean[w][h];
		int[][] temp = new int[w][h];
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < h; j++) {
				temp[i][j] = Integer.parseInt(st.nextToken());
				if (temp[i][j] == 2) {
					virus.add(new pair(i, j));
				}
			}
		}
		int max = 0;
		int n = w * h;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				for (int k = j + 1; k < n; k++) {

					int[][] arr = new int[w][h];
					for (int l = 0; l < w; l++) {
						for (int m = 0; m < h; m++) {
							arr[l][m] = temp[l][m];
							visit[l][m] = false;
						}
					}
					boolean signal = false;
					for (pair p : virus) {
						if (p.x == i / h && p.y == i % h)
							signal = true;
						if (p.x == j / h && p.y == j % h)
							signal = true;
						if (p.x == k / h && p.y == k % h)
							signal = true;
					}
					if (arr[i / h][i % h] == 1)
						signal = true;
					if (arr[j / h][j % h] == 1)
						signal = true;
					if (arr[k / h][k % h] == 1)
						signal = true;
					if (signal)
						continue;
					arr[i / h][i % h] = 1;
					arr[j / h][j % h] = 1;
					arr[k / h][k % h] = 1;
					Queue<pair> q = new LinkedList<pair>();
					for (pair p : virus) {
						q.offer(p);
						visit[p.x][p.y] = true;
					}
					while (!q.isEmpty()) {
						pair p = q.poll();
						for (int l = 0; l < 4; l++) {
							int nx = p.x + dx[l];
							int ny = p.y + dy[l];
							if (0 <= nx && nx < w && 0 <= ny && ny < h) {
								if (arr[nx][ny] != 1 && !visit[nx][ny]) {
									arr[nx][ny] = 2;
									visit[nx][ny] = true;
									q.offer(new pair(nx, ny));
								}
							}
						}
					}

					int cnt = 0;

					for (int l = 0; l < w; l++) {
						for (int m = 0; m < h; m++) {
							if (arr[l][m] == 0) {
								cnt++;
							}
						}
					}
					max = Math.max(max, cnt);
				}
		System.out.println(max);
	}
}
