package baekjoon.math;

import java.util.*;
import java.io.*;

public class b17436 {

	public static void getDividedNumber(int[] indexArray, int n, int r, int index, int target, char operation,
			long[] arr, long m) {
		if (r == 0) {
			long num = 1;
			for (int i : indexArray) {
				num = num * arr[i];
			}
			if (operation == '+')
				sum = sum + m / num;
			else
				sum = sum - m / num;
			return;
		}
		if (target == n)
			return;
		indexArray[index] = target;
		getDividedNumber(indexArray, n, r - 1, index + 1, target + 1, operation, arr, m);
		getDividedNumber(indexArray, n, r, index, target + 1, operation, arr, m);

	}

	public static long sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		for (int r = 1; r <= n; r++) {
			int[] indexArray = new int[r];
			char operation = '-';
			if (r % 2 == 1)
				operation = '+';
			getDividedNumber(indexArray, n, r, 0, 0, operation, arr, m);
		}
		System.out.println(sum);
	}
}
