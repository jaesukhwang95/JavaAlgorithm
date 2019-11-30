package baekjoon.bruteForce;

import java.io.*;
import java.util.*;

public class b17406 {
	public static int up = 0;
	public static int left = 1;
	public static int down = 2;
	public static int right = 3;
	public static int min = Integer.MAX_VALUE;

	public static class Information {
		int r;
		int c;
		int s;

		Information(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static void changePosition(int i, int j, int n, int m, int[][] arr, int[][] temp, int direction, int start) {
		do {
			if (direction == up) {
				if (i - 1 < start) {
					direction = right;
					continue;
				}
				temp[i - 1][j] = arr[i][j];
				i--;
			} else if (direction == left) {
				if (j - 1 < start) {
					direction = up;
					continue;
				}
				temp[i][j - 1] = arr[i][j];
				j--;
			} else if (direction == down) {
				if (i + 1 >= n - start) {
					direction = left;
					continue;
				}
				temp[i + 1][j] = arr[i][j];
				i++;
			} else if (direction == right) {
				if (j + 1 >= m - start) {
					direction = down;
					continue;
				}
				temp[i][j + 1] = arr[i][j];
				j++;
			}
		} while (i != start || j != start);
	}

	public static void rotateArray(int[][] arr, int r, int c, int s) {
		int[][] temp = new int[2 * s + 1][2 * s + 1];
		int[][] newTemp = new int[2 * s + 1][2 * s + 1];
		for (int i = 0; i < 2 * s + 1; i++) {
			for (int j = 0; j < 2 * s + 1; j++) {
				temp[i][j] = arr[i + r - s - 1][j + c - s - 1];
				newTemp[i][j] = temp[i][j];
			}
		}
		int start = 0;
		while (true) {
			int i = start;
			int j = start;
			if (start >= (2 * s + 1) / 2) {
				break;
			}
			changePosition(i, j, 2 * s + 1, 2 * s + 1, newTemp, temp, right, start);
			start++;
		}
		for (int i = 0; i < 2 * s + 1; i++) {
			for (int j = 0; j < 2 * s + 1; j++) {
				arr[i + r - s - 1][j + c - s - 1] = temp[i][j];
			}
		}
	}

	private static void findMinimum(int a, int b, LinkedList<Integer> indexList, int[] check, int[][] arr,
			Information[] rotationArrayList, int n, int m) {
		if (indexList.size() == b) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = buffer[i][j];
				}
			}
			for (int i : indexList) {
				rotateArray(arr, rotationArrayList[i].r, rotationArrayList[i].c, rotationArrayList[i].s);
			}
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < m; j++) {
					sum = sum + arr[i][j];
				}
				min = Math.min(min, sum);
			}
			return;
		}

		for (int i = 0; i < a; i++) {
			if (check[i] == 0) {
				indexList.add(i);
				check[i] = 1;
				findMinimum(a, b, indexList, check, arr, rotationArrayList, n, m);
				check[i] = 0;
				indexList.removeLast();
			}
		}

	}

	public static int[][] buffer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Information[] rotationArrayList = new Information[k];
		int[][] arr = new int[n][m];
		buffer = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				buffer[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			rotationArrayList[i] = new Information(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		LinkedList<Integer> indexList = new LinkedList<Integer>();
		int[] check = new int[k];
		findMinimum(k, k, indexList, check, arr, rotationArrayList, n, m);
		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}
}
