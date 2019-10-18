package baekjoon.bruteForce;

import java.io.*;
import java.util.*;

public class b7453 {

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

	public static void main(String[] args) throws IOException {

//		int[] arr = { 1, 3, 5, 6, 6, 6, 7, 9, 11 };
//		System.out.println(lowerBound(arr, 6));
//		System.out.println(upperBound(arr, 6));

//		6
//		-45 22 42 -16
//		-41 -27 56 30
//		-36 53 -37 77
//		-36 30 -75 -46
//		26 -38 -10 62
//		-32 -54 -6 45

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		long cnt = 0;
		int k = 0;
		int l = 0;
		int[] a = new int[total];
		int[] b = new int[total];
		int[] c = new int[total];
		int[] d = new int[total];
		int[] arr1 = new int[total * total];
		int[] arr2 = new int[total * total];		

		for (int i = 0; i < total; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < total; i++) {
			for (int j = 0; j < total; j++) {
				arr1[k++] = a[i] + b[j];
				arr2[l++] = c[i] + d[j];
			}
		}
		Arrays.sort(arr2);
		for (int i : arr1) {
			cnt += upperBound(arr2, -i) - lowerBound(arr2, -i);
		}
		System.out.println(cnt);
	}
}
