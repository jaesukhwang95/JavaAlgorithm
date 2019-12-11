package baekjoon.samsung.level3;

import java.io.*;
import java.util.StringTokenizer;

public class s1873 {

	public static void input(char cmd, char[][] arr, int n, int m) {
		if (cmd == 'U') {
			arr[x][y] = '^';
			if (0 <= x - 1 && arr[x - 1][y] == '.') {
				arr[x - 1][y] = '^';
				arr[x][y] = '.';
				x = x - 1;
			}
		} else if (cmd == 'D') {
			arr[x][y] = 'v';
			if (x + 1 < n && arr[x + 1][y] == '.') {
				arr[x + 1][y] = 'v';
				arr[x][y] = '.';
				x = x + 1;
			}
		} else if (cmd == 'L') {
			arr[x][y] = '<';
			if (0 <= y - 1 && arr[x][y - 1] == '.') {
				arr[x][y - 1] = '<';
				arr[x][y] = '.';
				y = y - 1;
			}
		} else if (cmd == 'R') {
			arr[x][y] = '>';
			if (y + 1 < m && arr[x][y + 1] == '.') {
				arr[x][y + 1] = '>';
				arr[x][y] = '.';
				y = y + 1;
			}
		} else if (cmd == 'S') {
			if (arr[x][y] == '^') {
				shoot(arr, n, m, -1, 0);
			} else if (arr[x][y] == 'v') {
				shoot(arr, n, m, 1, 0);
			} else if (arr[x][y] == '<') {
				shoot(arr, n, m, 0, -1);
			} else if (arr[x][y] == '>') {
				shoot(arr, n, m, 0, 1);
			}
		}
	}

	public static void shoot(char[][] arr, int n, int m, int dx, int dy) {
		int nx = x;
		int ny = y;
		while (true) {
			nx = nx + dx;
			ny = ny + dy;
			if (0 > nx || nx >= n || 0 > ny || ny >= m)
				break;
			if (arr[nx][ny] == '*') {
				arr[nx][ny] = '.';
				break;
			}
			if (arr[nx][ny] == '#') {
				break;
			}
		}
	}

	public static int x = 0;
	public static int y = 0;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int k = 0; k < t; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char[][] arr = new char[n][m];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}
			int num = Integer.parseInt(br.readLine());
			String commands = br.readLine();
			for (int i = 0; i < num; i++) {
				input(commands.charAt(i), arr, n, m);
			}
			sb.append("#").append(k + 1).append(" ");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}

		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
