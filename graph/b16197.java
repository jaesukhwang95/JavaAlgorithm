package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b16197 {

	public static class Position {
		int x;
		int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static char[][] arr;
	public static int h, w;
	public static int ans = Integer.MAX_VALUE;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void go(int cnt, int x1, int y1, int x2, int y2, int dir) {
		int nx1, ny1, nx2, ny2;
		for (int i = 0; i < 4; i++) {
			if (dir == i) {
				nx1 = x1 + dx[i];
				ny1 = y1 + dy[i];
				nx2 = x2 + dx[i];
				ny2 = y2 + dy[i];
				if (cnt > 10)
					return;
				if ((nx1 < 0 || nx1 >= h || ny1 < 0 || ny1 >= w) && (nx2 < 0 || nx2 >= h || ny2 < 0 || ny2 >= w)) {
					return;
				}
				if ((nx1 < 0 || nx1 >= h || ny1 < 0 || ny1 >= w) || (nx2 < 0 || nx2 >= h || ny2 < 0 || ny2 >= w)) {
					ans = Math.min(ans, cnt + 1);
					return;
				}
				if (arr[nx1][ny1] == '#') {
					nx1 = x1;
					ny1 = y1;
				}
				if (arr[nx2][ny2] == '#') {
					nx2 = x2;
					ny2 = y2;
				}
				for (int k = 0; k < 4; k++)
					go(cnt + 1, nx1, ny1, nx2, ny2, k);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		int k = 0;
		Position[] coin = new Position[2];
		arr = new char[h][w];
		for (int i = 0; i < h; i++) {
			String str = br.readLine();
			for (int j = 0; j < w; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'o') {
					coin[k++] = new Position(i, j);
				}
			}
		}
		for (int i = 0; i < 4; i++)
			go(0, coin[0].x, coin[0].y, coin[1].x, coin[1].y, i);
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else if (ans > 10)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}