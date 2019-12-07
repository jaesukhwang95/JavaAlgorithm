package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b17141 {

	public static int virus = -3;
	public static int wall = -2;
	public static int empty = -1;
	public static int min = Integer.MAX_VALUE;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int[][] temp;

	public static class Info {
		int x;
		int y;
		int cnt;

		Info(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void findMinimum(int[] indexArray, int k, int r, int index, int target, ArrayList<Info> virusList,
			int[][] lab, int n) {
		if (r == 0) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					lab[i][j] = temp[i][j];
			int time = spreadVirus(indexArray, virusList, lab, n);
			min = Math.min(min, time);
			return;
		}
		if (target == k)
			return;
		indexArray[index] = target;
		findMinimum(indexArray, k, r - 1, index + 1, target + 1, virusList, lab, n);
		findMinimum(indexArray, k, r, index, target + 1, virusList, lab, n);
	}

	public static int spreadVirus(int[] indexArray, ArrayList<Info> virusList, int[][] lab, int n) {
		Queue<Info> q = new LinkedList<Info>();
		for (int i : indexArray) {
			Info virus = virusList.get(i);
			q.offer(new Info(virus.x, virus.y, virus.cnt));
			lab[virus.x][virus.y] = virus.cnt;
		}
		while (!q.isEmpty()) {
			Info p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (lab[nx][ny] == empty) {
						lab[nx][ny] = p.cnt + 1;
						q.offer(new Info(nx, ny, p.cnt + 1));
					}
				}
			}
		}
		int time = findTime(lab, n);
		return time;
	}

	public static int findTime(int[][] lab, int n) {
		boolean signal = false;
		int max = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				max = Math.max(max, lab[i][j]);
				if (lab[i][j] == empty) {
					signal = true;
					break;
				}
			}
		if (signal)
			return Integer.MAX_VALUE;
		else
			return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int[][] lab = new int[n][n];
		temp = new int[n][n];
		ArrayList<Info> virusList = new ArrayList<Info>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					virusList.add(new Info(i, j, 0));
					lab[i][j] = empty;
					cnt++;
				} else if (num == 1) {
					lab[i][j] = wall;
				} else if (num == 0) {
					lab[i][j] = empty;
				}
			}
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				temp[i][j] = lab[i][j];

		int[] indexArray = new int[m];
		findMinimum(indexArray, cnt, m, 0, 0, virusList, lab, n);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}
}
