package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b16946 {

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		char[][] wall = new char[w][h];
		int[][] ans = new int[w][h];
		int[][] output = new int[w][h];

		boolean[][] wallVisit = new boolean[w][h];
		for (int i = 0; i < w; i++) {
			String str = br.readLine();
			for (int j = 0; j < h; j++) {
				wall[i][j] = str.charAt(j);
			}
		}

		int cnt = 1;
		int[] group = new int[500001];

		for (int j = 0; j < w; j++)
			for (int k = 0; k < h; k++) {
				if (wallVisit[j][k])
					continue;
				if (wall[j][k] == '1')
					continue;

				int x = j;
				int y = k;

				Queue<Integer> q = new LinkedList<Integer>();
				q.offer(x);
				q.offer(y);
				wallVisit[x][y] = true;
				ans[x][y] = cnt;
				group[cnt]++;
				while (!q.isEmpty()) {
					int px = q.poll();
					int py = q.poll();
					for (int i = 0; i < 4; i++) {
						int nx = px + dx[i];
						int ny = py + dy[i];
						if (0 <= nx && nx < w && 0 <= ny && ny < h && !wallVisit[nx][ny] && wall[nx][ny] != '1') {
							q.offer(nx);
							q.offer(ny);
							wallVisit[nx][ny] = true;
							ans[nx][ny] = cnt;
							group[cnt]++;
						}
					}
				}
				cnt++;
			}

		boolean[] groupVisit = new boolean[cnt];

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				for (int k = 1; k < cnt; k++)
					groupVisit[k] = false;

				int count = 0;
				if (wall[i][j] == '0')
					continue;
				else {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (0 <= nx && nx < w && 0 <= ny && ny < h && !groupVisit[ans[nx][ny]]) {
							count += group[ans[nx][ny]] % 10;
							groupVisit[ans[nx][ny]] = true;
						}
					}
					output[i][j] = (count + 1) % 10;
				}
			}
		}
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				System.out.print(output[i][j]);
			}
			System.out.println();
		}
	}
}