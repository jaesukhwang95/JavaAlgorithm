package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b16971 {

	public static int addElement(int[][] arr, int n, int m) {
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				sum += arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i][j + 1];
			}
		}
		return sum;
	}

	public static void changeColumn(int[][] arr, int n, int m, int idx1, int idx2) {
		// m Combination 2
		for (int i = 0; i < n; i++) {
			int temp = arr[i][idx1];
			arr[i][idx1] = arr[i][idx2];
			arr[i][idx2] = temp;
		}
	}

	public static void changeRow(int[][] arr, int n, int m, int idx1, int idx2) {
		// n Combination 2
		for (int i = 0; i < m; i++) {
			int temp = arr[idx1][i];
			arr[idx1][i] = arr[idx2][i];
			arr[idx2][i] = temp;
		}
	}

	public static void findMaximum(int[] idxArray, int a, int b, int index, int target, String str, int[][] arr, int n,
			int m) {
		if (b == 0) {
			int sum = 0;
			if (str.equals("row"))
				changeRow(arr, n, m, idxArray[0], idxArray[1]);
			else if (str.equals("column"))
				changeColumn(arr, n, m, idxArray[0], idxArray[1]);
			sum = addElement(arr, n, m);
			maxValue = Math.max(maxValue, sum);
			makeOriginalArray(arr, original, n, m);
			return;
		}
		if (target == a)
			return;

		idxArray[index] = target;
		findMaximum(idxArray, a, b - 1, index + 1, target + 1, str, arr, n, m);
		findMaximum(idxArray, a, b, index, target + 1, str, arr, n, m);

	}

	public static int[][] makeOriginalArray(int[][] input, int[][] original, int n, int m) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				input[i][j] = original[i][j];
		return input;
	}

	public static int maxValue = Integer.MIN_VALUE;
	public static int[][] original;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		original = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				original[i][j] = arr[i][j];
			}
		}

		int[] idxArray = new int[2];
		findMaximum(idxArray, n, 2, 0, 0, "row", arr, n, m);
		idxArray = new int[2];
		findMaximum(idxArray, m, 2, 0, 0, "column", arr, n, m);
		System.out.println(maxValue);
	}
}
