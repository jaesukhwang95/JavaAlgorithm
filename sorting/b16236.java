package baekjoon.sorting;

import java.util.*;
import java.io.*;

public class b16236 {

	public static class Shark {
		int size;
		int x;
		int y;
		int eat;

		public Shark(int size, int x, int y, int eat) {
			this.size = size;
			this.x = x;
			this.y = y;
			this.eat = eat;
		}
	}

	public static class Point implements Comparable<Point> {
		int x;
		int y;
		int dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point a) {
			if (this.dist < a.dist)
				return -1;
			else if (this.dist == a.dist) {
				{
					if (this.x < a.x)
						return -1;
					else if (this.x == a.x) {
						if (this.y < a.y)
							return -1;
						else
							return 1;
					} else
						return 1;
				}
			} else {
				return 1;
			}
		}
	}

	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] space = new int[n][n];
		Shark baby = null;
		int sum = 0;
		boolean[][] visit = new boolean[n][n];
		boolean[][] fish = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if (space[i][j] == 9) {
					baby = new Shark(2, i, j, 0);
				}
				if (space[i][j] == 1 || space[i][j] == 2 || space[i][j] == 3 || space[i][j] == 4 || space[i][j] == 5
						|| space[i][j] == 6) {
					fish[i][j] = true;
				}
			}
		}
		while (true) {

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					visit[i][j] = false;
			Queue<Point> q = new LinkedList<Point>();
			q.offer(new Point(baby.x, baby.y, 0));
			visit[baby.x][baby.y] = true;
			ArrayList<Point> fishGroup = new ArrayList<Point>();
			while (!q.isEmpty()) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (0 <= nx && nx < n && 0 <= ny && ny < n) {
						if (!visit[nx][ny] && baby.size >= space[nx][ny]) {
							visit[nx][ny] = true;
							q.offer(new Point(nx, ny, p.dist + 1));
							if (fish[nx][ny] && baby.size > space[nx][ny]) {
								fishGroup.add(new Point(nx, ny, p.dist + 1));
							}
						}
					}
				}
			}
			if (fishGroup.size() == 0) {
				break;
			} else {
				Collections.sort(fishGroup);
				baby.eat++;
				if (baby.eat == baby.size) {
					baby.size = baby.size + 1;
					baby.eat = 0;
				}
				space[baby.x][baby.y] = 0;
				baby.x = fishGroup.get(0).x;
				baby.y = fishGroup.get(0).y;
				sum += fishGroup.get(0).dist;
				space[baby.x][baby.y] = 9;
				fish[baby.x][baby.y] = false;
			}
		}

		System.out.println(sum);
	}
}
