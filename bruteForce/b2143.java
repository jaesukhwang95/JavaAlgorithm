package baekjoon.bruteForce;

import java.io.*;
import java.util.*;

public class b2143 {

	public static int upperBound(int[] arr, int num) {
		int left = 0;
		int right = arr.length;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] <= num) {
				left = mid + 1;

			} else {
				right = mid;
			}
		}
		return left;
	}

	public static int lowerBound(int[] arr, int num) {
		int left = 0;
		int right = arr.length;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] >= num) {
				right = mid;
			} else {
				left = mid + 1;

			}
		}
		return left;
	}

	public static void makeSum(int[] sum, int[] element, int n) {
		int l = 0;
		for (int k = 1; k < n; k++) {
			Loop: for (int i = 0; i < n; i++) {
				for (int j = i; j < i + k; j++) {
					if (i + k > n) {
						break Loop;
					}
					sum[l] = sum[l] + element[j];
				}
				l++;
			}
		}
		for (int j = 0; j < n; j++)
			sum[l] = sum[l] + element[j];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			b[i] = Integer.parseInt(st.nextToken());

		int[] sumA = new int[n * (n + 1) / 2];
		int[] sumB = new int[m * (m + 1) / 2];

		makeSum(sumA, a, n);
		makeSum(sumB, b, m);

		Arrays.sort(sumA);

		long cnt = 0;
		for (int diff : sumB) {
			int target = result - diff;
			cnt += (long) upperBound(sumA, target) - (long) lowerBound(sumA, target);
		}
		System.out.println(cnt);
	}
}
