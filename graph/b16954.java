package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b16954 {

	public static char[][] changePlate(char[][] plate, int cnt) {
		char[][] newPlate = new char[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				newPlate[i][j] = '.';
			}
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (plate[i][j] == '#') {
					if (i + cnt < 8) {
						newPlate[i + cnt][j] = '#';
					}
				}
			}
		}
		return newPlate;
	}

	public static int[] dx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	public static int[] dy = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	public static class Player {
		int x;
		int y;
		int cnt;

		public Player(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] plate = new char[8][8];
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				plate[i][j] = str.charAt(j);
			}
		}

		Queue<Player> q = new LinkedList<Player>();
		q.offer(new Player(7, 0, 0));
		while (!q.isEmpty()) {
			Player player = q.poll();
			boolean signal = false;
			char[][] newPlate = new char[8][8];
			newPlate = changePlate(plate, player.cnt);
			for (int i = 0; i < player.x; i++)
				for (int j = 0; j < 8; j++) {
					if (newPlate[i][j] == '#')
						signal = true;
				}
			if (!signal) {
				System.out.println(1);
				System.exit(0);
			}

			for (int i = 0; i < 9; i++) {
				int nx = player.x + dx[i];
				int ny = player.y + dy[i];
				if (0 <= nx && nx < 8 && 0 <= ny && ny < 8) {
					if (nx >= 1) {
						if (newPlate[nx][ny] == '.' && newPlate[nx - 1][ny] == '.') {
							q.offer(new Player(nx, ny, player.cnt + 1));
						}
					} else {
						if (newPlate[nx][ny] == '.') {
							q.offer(new Player(nx, ny, player.cnt + 1));
						}
					}
				}
			}
		}
		System.out.println(0);
	}
}
