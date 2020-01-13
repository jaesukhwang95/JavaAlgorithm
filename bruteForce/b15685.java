package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b15685 {

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static ArrayList<Pair> arr = new ArrayList<Pair>();

	public static Pair changeDirection(int x, int y, int dir) {
		if (dir == 0) {
			return new Pair(x + 1, y);
		} else if (dir == 1) {
			return new Pair(x, y - 1);
		} else if (dir == 2) {
			return new Pair(x - 1, y);
		} else {
			return new Pair(x, y + 1);
		}
	}

	public static void makeDragonCurve(int x, int y, int dir, int generation, boolean[][] visit) {
		int size = (int) Math.pow(2, generation);
		int[] nextDirection = new int[size];
		nextDirection[0] = dir;
		int i = 1;
		while (i != size) {
			for (int j = 0; j < i; j++) {
				nextDirection[2 * i - j - 1] = (nextDirection[j] + 1) % 4;
			}
			i = i * 2;
		}
		visit[x][y] = true;
		for (int j = 0; j < size; j++) {
			Pair p = changeDirection(x, y, nextDirection[j]);
			x = p.x;
			y = p.y;
			visit[x][y] = true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		boolean[][] visit = new boolean[101][101];
		int cnt = 0;
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int generation = Integer.parseInt(st.nextToken());
			makeDragonCurve(x, y, dir, generation, visit);
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++)
				if (visit[i][j] && visit[i + 1][j] && visit[i][j + 1] && visit[i + 1][j + 1])
					cnt++;
		}
		System.out.println(cnt);
	}
}
