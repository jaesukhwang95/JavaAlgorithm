package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b4991 {

	public static class Pos {
		int num;
		int x;
		int y;

		public Pos(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static ArrayList<Pos> list;
	public static int[][] arr;
	public static int[][] tmp;
	public static boolean[][] visit;
	public static boolean[] check;
	public static int[][] dist;
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static int w, h, min;

	public static void bfs(int x, int y) {
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				arr[i][j] = tmp[i][j];
		Pair p = new Pair(x, y);
		arr[x][y] = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(p);
		while (!q.isEmpty()) {
			Pair el = q.poll();
			int elX = el.x;
			int elY = el.y;
			for (int i = 0; i < 4; i++) {
				int nx = elX + dx[i];
				int ny = elY + dy[i];
				if (nx < 0 || nx >= h || ny < 0 || ny >= w)
					continue;
				else if (arr[nx][ny] != 0)
					continue;
				else {
					arr[nx][ny] = arr[elX][elY] + 1;
					q.offer(new Pair(nx, ny));
				}
			}
		}
	}

	public static void dfs(int prev, int sum, int idx, int size) {
		if (idx == size - 1) {
//			System.out.print(sum+" ");
			if (min > sum)
				min = sum;
			return;
		}
		for (int i = 1; i < size; i++) {
			if (!check[i]) {
				if (sum + dist[prev][i] > min)
					continue;
				check[i] = true;
				dfs(i, sum + dist[prev][i], idx + 1, size);
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			arr = new int[h][w];
			tmp = new int[h][w];
			list = new ArrayList<Pos>();
			int dustCount = 1;
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					char c = str.charAt(j);
					if (c == 'o') {
						list.add(0, new Pos(0, i, j));
					} else if (c == '*') {
						list.add(new Pos(dustCount, i, j));
						dustCount++;
					} else if (c == 'x') {
						arr[i][j] = -1;
						tmp[i][j] = -1;
					}
				}
			}
			dist = new int[dustCount + 1][dustCount + 1];
			check = new boolean[dustCount + 1];
			for (Pos p : list) {
				bfs(p.x, p.y);
				{
					for (int i = p.num + 1; i < list.size(); i++) {
						Pos nextP = list.get(i);
						dist[p.num][nextP.num] = arr[nextP.x][nextP.y] - 1;
						dist[nextP.num][p.num] = arr[nextP.x][nextP.y] - 1;
					}
				}
			}
			boolean signal = false;
			for (int i = 0; i < dustCount; i++) {
				for (int j = 0; j < dustCount; j++) {
					if (dist[i][j] == -1)
						signal = true;
				}
			}
			if (signal)
				sb.append(-1).append("\n");
			else {
				min = Integer.MAX_VALUE;
				check[0] = true;
				dfs(0, 0, 0, dustCount);
				sb.append(min).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
}
