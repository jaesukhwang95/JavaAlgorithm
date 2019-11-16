package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b10816 {

	public static int lowerBound(int num, int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int ans = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == num) {
				ans = mid;
				right = mid - 1;
			} else if (arr[mid] < num) {
				left = mid + 1;
			} else if (arr[mid] > num) {
				right = mid - 1;
			}
		}
		return ans;
	}

	public static int upperBound(int num, int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int ans = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == num) {
				ans = mid;
				left = mid + 1;
			} else if (arr[mid] < num) {
				left = mid + 1;
			} else if (arr[mid] > num) {
				right = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] card = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		Arrays.sort(card);
		int[] data = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			int upper = upperBound(data[i], card);
			int lower = lowerBound(data[i], card);
			if (upper == -1 && lower == -1)
				sb.append("0 ");
			else
				sb.append(upper - lower + 1 + " ");
		}
		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb.toString());
	}
}
