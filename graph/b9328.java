package baekjoon.graph;

import java.io.*;
import java.util.*;

public class b9328 {

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 > nx || nx >= h || 0 > ny || ny >= w)
					continue;
				else if (arr[nx][ny] == '*')
					continue;
				else if (visit[nx][ny])
					continue;
				else if (65 <= (int) arr[nx][ny] && (int) arr[nx][ny] <= 90) {
					Character alpha = (char) (arr[nx][ny] + 32);
					if (key.contains(alpha)) {
						visit[nx][ny] = true;
						q.offer(new Pair(nx, ny));
					} else {
						door.add(new Pair(nx, ny));
						continue;
					}
				} else if (97 <= (int) arr[nx][ny] && (int) arr[nx][ny] <= 122) {
					key.add(arr[nx][ny]);
					visit[nx][ny] = true;
					q.offer(new Pair(nx, ny));

					for (Pair d : door) {
						Character alpha = (char) (arr[d.x][d.y] + 32);
						if (key.contains(alpha)) {
							visit[nx][ny] = true;
							q.offer(new Pair(d.x, d.y));
						}
					}
				} else if (arr[nx][ny] == '$') {
					visit[nx][ny] = true;
					q.offer(new Pair(nx, ny));
					count += 1;
				} else {
					visit[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
	}

	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static int h, w;
	public static char[][] arr;
	public static boolean[][] visit;
	public static Queue<Pair> q;
	public static HashSet<Character> key;
	public static HashSet<Pair> door;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken()) + 2;
			w = Integer.parseInt(st.nextToken()) + 2;
			arr = new char[h][w];
			visit = new boolean[h][w];
			key = new HashSet<Character>();
			door = new HashSet<Pair>();
			count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					arr[i][j] = '.';
				}
			}
			for (int i = 0; i < h - 2; i++) {
				String str = br.readLine();
				for (int j = 0; j < w - 2; j++) {
					arr[i + 1][j + 1] = str.charAt(j);
				}
			}
			String keys = br.readLine();
			if (keys.equals("0")) {

			} else {
				for (int i = 0; i < keys.length(); i++) {
					key.add(keys.charAt(i));
				}
			}
			q = new LinkedList<Pair>();
			q.offer(new Pair(0, 0));
			visit[0][0] = true;
			bfs();
			sb.append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
