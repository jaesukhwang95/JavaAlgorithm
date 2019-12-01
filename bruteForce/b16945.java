package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b16945 {

	public static boolean checkMagicSquare(int[] arr) {
		int sum = arr[0] + arr[1] + arr[2];
		if (sum != arr[3] + arr[4] + arr[5]) {
			return false;
		} else if (sum != arr[6] + arr[7] + arr[8]) {
			return false;
		} else if (sum != arr[0] + arr[3] + arr[6]) {
			return false;
		} else if (sum != arr[1] + arr[4] + arr[7]) {
			return false;
		} else if (sum != arr[2] + arr[5] + arr[8]) {
			return false;
		} else if (sum != arr[0] + arr[4] + arr[8]) {
			return false;
		} else if (sum != arr[2] + arr[4] + arr[6]) {
			return false;
		} else
			return true;
	}

	public static int findCost(int[] changedArray, int[] originalArray) {
		int ans = 0;
		for (int i = 0; i < 9; i++) {
			ans = ans + Math.abs(changedArray[i] - originalArray[i]);
		}
		return ans;
	}

	public static void findMinimum(int n, int r, LinkedList<Integer> indexList, int[] check, int[] originalArray) {
		if (indexList.size() == r) {
			int k = 0;
			int[] changedArray = new int[9];
			for (int i : indexList) {
				changedArray[k++] = i + 1;
			}
			if (checkMagicSquare(changedArray)) {
				int cost = findCost(changedArray, originalArray);
				min = Math.min(cost, min);
				return;
			}
		}
		for (int i = 0; i < n; i++) {
			if (check[i] == 0) {
				indexList.add(i);
				check[i] = 1;
				findMinimum(n, r, indexList, check, originalArray);
				check[i] = 0;
				indexList.removeLast();
			}
		}

	}

	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] originalArray = new int[9];
		int k = 0;
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				originalArray[k++] = Integer.parseInt(st.nextToken());
		}
		LinkedList<Integer> indexList = new LinkedList<Integer>();
		int[] check = new int[9];
		findMinimum(9, 9, indexList, check, originalArray);
		System.out.println(min);
	}
}