package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b16974 {

	public static class Pair {
		int x;
		int y;
		int cnt;

		Pair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int hashCode() {
			return x + y + cnt;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Pair) {
				Pair p = (Pair) obj;
				return (p.x == (x)) && (p.y == (y)) && (p.cnt == (cnt));
			} else {
				return false;
			}
		}
	}

	public static boolean checkArrayIndex(int x, int y, int row, int col) {
		if (0 <= x && x < row && 0 <= y && y < col)
			return true;
		else
			return false;
	}

	public static boolean checkArrayStar(int x, int y, char[][] arr) {
		if (arr[x][y] == '.')
			return false;
		else
			return true;
	}

	public static Pair cross(int x, int y, char[][] arr, int row, int col) {
		int cnt = 0;
		int i = 1;
		while (true) {
			if (!checkArrayIndex(x + i, y, row, col) || !checkArrayIndex(x - i, y, row, col)
					|| !checkArrayIndex(x, y + i, row, col) || !checkArrayIndex(x, y - i, row, col))
				break;
			if (!checkArrayStar(x + i, y, arr) || !checkArrayStar(x - i, y, arr) || !checkArrayStar(x, y + i, arr)
					|| !checkArrayStar(x, y - i, arr))
				break;
			arr[x][y] = 'x';
			arr[x + i][y] = 'x';
			arr[x - i][y] = 'x';
			arr[x][y + i] = 'x';
			arr[x][y - i] = 'x';
			cnt++;
			i++;
		}
		if (cnt == 0)
			return new Pair(-1, -1, 0);
		else
			return new Pair(x, y, cnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] arr = new char[row][col];
		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		HashSet<Pair> set = new HashSet<Pair>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				if (arr[i][j] == '*' || arr[i][j] == 'x')
					set.add(cross(i, j, arr, row, col));
		}
		boolean signal = false;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				if (arr[i][j] == '*') {
					signal = true;
					break;
				}
		}
		set.remove(new Pair(-1, -1, 0));

		if (signal) {
			System.out.println(-1);
		} else {
			System.out.println(set.size());
			for (Pair i : set) {
				System.out.println((i.x + 1) + " " + (i.y + 1) + " " + i.cnt);
			}
		}
	}
}