package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b17070 {

	public static int horizontal = 0;
	public static int vertical = 1;
	public static int diagonal = 2;
	public static int cnt = 0;

	public static class Pipe {
		int x;
		int y;
		int status;

		Pipe(int x, int y, int status) {
			this.x = x;
			this.y = y;
			this.status = status;
		}
	}

	public static void findWays(Pipe p, int n, int[][] house) {
		int x = p.x;
		int y = p.y;
		int status = p.status;
		if (x == n - 1 && y == n - 1) {
			cnt++;
			return;
		}
		if (status == horizontal) {
			if (0 <= x && x < n && 0 <= (y + 1) && (y + 1) < n && (house[x][y + 1] == 0)) {
				findWays(new Pipe(x, y + 1, horizontal), n, house);
			}
			if (0 <= (x + 1) && (x + 1) < n && 0 <= (y + 1) && (y + 1) < n && (house[x + 1][y] == 0)
					&& (house[x][y + 1] == 0) && (house[x + 1][y + 1] == 0)) {
				findWays(new Pipe(x + 1, y + 1, diagonal), n, house);
			}
		} else if (status == vertical) {
			if (0 <= (x + 1) && (x + 1) < n && 0 <= y && y < n && (house[x + 1][y] == 0)) {
				findWays(new Pipe(x + 1, y, vertical), n, house);
			}
			if (0 <= (x + 1) && (x + 1) < n && 0 <= (y + 1) && (y + 1) < n && (house[x + 1][y] == 0)
					&& (house[x][y + 1] == 0) && (house[x + 1][y + 1] == 0)) {
				findWays(new Pipe(x + 1, y + 1, diagonal), n, house);
			}
		} else if (status == diagonal) {
			if (0 <= x && x < n && 0 <= (y + 1) && (y + 1) < n && (house[x][y + 1] == 0)) {
				findWays(new Pipe(x, y + 1, horizontal), n, house);
			}
			if (0 <= (x + 1) && (x + 1) < n && 0 <= y && y < n && (house[x + 1][y] == 0)) {
				findWays(new Pipe(x + 1, y, vertical), n, house);
			}
			if (0 <= (x + 1) && (x + 1) < n && 0 <= (y + 1) && (y + 1) < n && (house[x + 1][y] == 0)
					&& (house[x][y + 1] == 0) && (house[x + 1][y + 1] == 0)) {
				findWays(new Pipe(x + 1, y + 1, diagonal), n, house);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findWays(new Pipe(0, 1, horizontal), n, house);
		System.out.println(cnt);
	}
}
