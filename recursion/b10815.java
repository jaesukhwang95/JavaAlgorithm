package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b10815 {

	public static boolean binarySearch(int num, int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == num) {
				return true;
			}
			if (arr[mid] > num)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] have = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			have[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[] data = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(have);
		for (int i = 0; i < m; i++) {
			if (binarySearch(data[i], have))
				sb.append(1 + " ");
			else
				sb.append(0 + " ");
		}
		sb.delete((sb.length() - 1), sb.length());
		System.out.println(sb.toString());
	}
}
