package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b16926 {

	public static int up = 0;
	public static int left = 1;
	public static int down = 2;
	public static int right = 3;

	public static void changePosition(int i, int j, int n, int m, int[][] arr, int[][] temp, int direction, int start) {
		do {
			if (direction == up) {
				if (i - 1 < start) {
					direction = left;
					continue;
				}
				temp[i - 1][j] = arr[i][j];
				i--;
			} else if (direction == left) {
				if (j - 1 < start) {
					direction = down;
					continue;
				}
				temp[i][j - 1] = arr[i][j];
				j--;
			} else if (direction == down) {
				if (i + 1 >= n - start) {
					direction = right;
					continue;
				}
				temp[i + 1][j] = arr[i][j];
				i++;
			} else if (direction == right) {
				if (j + 1 >= m - start) {
					direction = up;
					continue;
				}
				temp[i][j + 1] = arr[i][j];
				j++;
			}
		} while (i != start || j != start);
	}

	public static void rotateArray(int[][] arr, int n, int m) {
		int[][] temp = new int[n][m];
		int min = Math.min(n, m);
		int start = 0;
		while (true) {
			int i = start;
			int j = start;
			if (start >= min / 2) {
				break;
			}
			changePosition(i, j, n, m, arr, temp, down, start);
			start++;
		}
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < m; b++) {
				arr[a][b] = temp[a][b];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (r-- > 0)
			rotateArray(arr, n, m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
