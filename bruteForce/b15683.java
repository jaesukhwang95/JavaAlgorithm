package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b15683 {

	public static class Cctv {
		int x;
		int y;
		int num;

		Cctv(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	public static int up = 0;
	public static int left = 1;
	public static int down = 2;
	public static int right = 3;

	public static void watch(int x, int y, int dir, int[][] office, int row, int col) {
		if (dir == up) {
			while (true) {
				x = x - 1;
				if (0 <= x && x < row && office[x][y] != 6) {
					if (office[x][y] == 0)
						office[x][y] = -1;
				} else {
					break;
				}
			}
		}
		if (dir == left) {
			while (true) {
				y = y - 1;
				if (0 <= y && y < col && office[x][y] != 6) {
					if (office[x][y] == 0)
						office[x][y] = -1;
				} else {
					break;
				}
			}
		}
		if (dir == down) {
			while (true) {
				x = x + 1;
				if (0 <= x && x < row && office[x][y] != 6) {
					if (office[x][y] == 0)
						office[x][y] = -1;
				} else {
					break;
				}
			}
		}
		if (dir == right) {
			while (true) {
				y = y + 1;
				if (0 <= y && y < col && office[x][y] != 6) {
					if (office[x][y] == 0)
						office[x][y] = -1;
				} else {
					break;
				}
			}
		}
	}

	public static void watchResult(int idx, int num, int x, int y, int[][] office, int row, int col) {
		if (num == 1 && idx == 0) {
			watch(x, y, up, office, row, col);
		} else if (num == 1 && idx == 1) {
			watch(x, y, left, office, row, col);
		} else if (num == 1 && idx == 2) {
			watch(x, y, down, office, row, col);
		} else if (num == 1 && idx == 3) {
			watch(x, y, right, office, row, col);
		} else if (num == 2 && (idx == 0 || idx == 2)) {
			watch(x, y, up, office, row, col);
			watch(x, y, down, office, row, col);
		} else if (num == 2 && (idx == 1 || idx == 3)) {
			watch(x, y, left, office, row, col);
			watch(x, y, right, office, row, col);
		} else if (num == 3 && idx == 0) {
			watch(x, y, up, office, row, col);
			watch(x, y, right, office, row, col);
		} else if (num == 3 && idx == 1) {
			watch(x, y, right, office, row, col);
			watch(x, y, down, office, row, col);
		} else if (num == 3 && idx == 2) {
			watch(x, y, down, office, row, col);
			watch(x, y, left, office, row, col);
		} else if (num == 3 && idx == 3) {
			watch(x, y, left, office, row, col);
			watch(x, y, up, office, row, col);
		} else if (num == 4 && idx == 0) {
			watch(x, y, up, office, row, col);
			watch(x, y, right, office, row, col);
			watch(x, y, down, office, row, col);
		} else if (num == 4 && idx == 1) {
			watch(x, y, right, office, row, col);
			watch(x, y, down, office, row, col);
			watch(x, y, left, office, row, col);
		} else if (num == 4 && idx == 2) {
			watch(x, y, left, office, row, col);
			watch(x, y, up, office, row, col);
			watch(x, y, down, office, row, col);
		} else if (num == 4 && idx == 3) {
			watch(x, y, left, office, row, col);
			watch(x, y, up, office, row, col);
			watch(x, y, right, office, row, col);
		} else if (num == 5 && (idx == 0 || idx == 1 || idx == 2 || idx == 3)) {
			watch(x, y, left, office, row, col);
			watch(x, y, up, office, row, col);
			watch(x, y, down, office, row, col);
			watch(x, y, right, office, row, col);
		}
	}

	public static ArrayList<Cctv> set;
	public static int min;
	public static int[][] office;
	public static int row;
	public static int col;

	public static void indexGenerator(int n, int r, LinkedList<Integer> indexList) {
		if (indexList.size() == r) {
			int k = 0;
			int cnt = 0;
			for (int idx : indexList) {
				watchResult(idx, set.get(k).num, set.get(k).x, set.get(k).y, office, row, col);
				k++;
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++)
					if (office[i][j] == 0)
						cnt++;
			}
			if (cnt < min) {
				min = cnt;
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (office[i][j] == -1)
						office[i][j] = 0;

				}
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			indexList.add(i);
			indexGenerator(n, r, indexList);
			indexList.removeLast();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		office = new int[row][col];
		set = new ArrayList<Cctv>();
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] != 0 && office[i][j] != 6) {
					set.add(new Cctv(i, j, office[i][j]));
				}
			}
		}
		min = Integer.MAX_VALUE;
		LinkedList<Integer> indexList = new LinkedList<Integer>();
		indexGenerator(4, set.size(), indexList);
		System.out.println(min);

	}
}
