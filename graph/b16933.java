package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b16933 {

	public static class Player {
		int x;
		int y;
		int brokenWall;
		int dist;

		public Player(int x, int y, int brokenWall, int dist) {
			this.x = x;
			this.y = y;
			this.brokenWall = brokenWall;
			this.dist = dist;
		}
	}

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] space = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				space[i][j] = str.charAt(j) - '0';
			}
		}
		boolean[][][] visit = new boolean[n][m][k + 1];
		String signal = "Day";
		Queue<Player> q = new LinkedList<Player>();
		q.offer(new Player(0, 0, 0, 1));
		visit[0][0][0] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0)
			{
				Player player = q.poll();
				int x = player.x;
				int y = player.y;
				int brokenwall = player.brokenWall;
				int dist = player.dist;

				if (x == n - 1 && y == m - 1) {
					System.out.println(dist);
					System.exit(0);
				}

				if (signal.equals("Day")) {
					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if (0 <= nx && nx < n && 0 <= ny && ny < m) {
							if (!visit[nx][ny][brokenwall] && space[nx][ny] == 0) {
								visit[nx][ny][brokenwall] = true;
								q.offer(new Player(nx, ny, brokenwall, dist + 1));
							}

							if (brokenwall <= k - 1 && !visit[nx][ny][brokenwall + 1] && space[nx][ny] == 1) {
								visit[nx][ny][brokenwall + 1] = true;
								q.offer(new Player(nx, ny, brokenwall + 1, dist + 1));
							}
						}
					}
				}

				if (signal.equals("Night")) {
					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if (0 <= nx && nx < n && 0 <= ny && ny < m) {
							if (!visit[nx][ny][brokenwall] && space[nx][ny] == 0) {
								visit[nx][ny][brokenwall] = true;
								q.offer(new Player(nx, ny, brokenwall, dist + 1));
							}
							if (space[nx][ny] == 1) {
								q.offer(new Player(x, y, brokenwall, dist + 1));
							}
						}
					}

				}
			}
			if (signal.equals("Day")) {
				signal = "Night";
				continue;
			}
			if (signal.equals("Night")) {
				signal = "Day";
			}
		}
		System.out.println(-1);
	}
}