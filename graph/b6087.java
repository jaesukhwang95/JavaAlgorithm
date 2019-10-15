package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b6087 {

	public static class Point {
		int x;
		int y;
		int cnt;
		int dir;

		Point(int x, int y, int cnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}

	public static int[][] count;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static Point[] endPoint = new Point[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		char[][] arr = new char[w][h];
		int[][] count = new int[w][h];
		int idx = 0;
		for (int i = 0; i < w; i++) {
			String str = br.readLine();
			for (int j = 0; j < h; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'C') {
					endPoint[idx] = new Point(i, j, 0, -1);
					idx++;
				}
				count[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<Point> q = new LinkedList<Point>();
		Point start = endPoint[0];
		q.offer(start);
		while (!q.isEmpty()) {
			Point now = q.poll();
			int x = now.x;
			int y = now.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= w || ny < 0 || ny >= h)
					continue;
				else if (arr[nx][ny] == '*')
					continue;
				else {
					if (now.dir == i || now.dir == -1) {
						if (count[nx][ny] < now.cnt)
							continue;
						else {
							count[nx][ny] = now.cnt;
							q.offer(new Point(nx, ny, now.cnt, i));
						}
					} else {
						if (count[nx][ny] < now.cnt + 1)
							continue;
						else {
							count[nx][ny] = now.cnt + 1;
							q.offer(new Point(nx, ny, now.cnt + 1, i));
						}
					}
				}
			}
		}

		System.out.println(count[endPoint[1].x][endPoint[1].y]);

	}
}
