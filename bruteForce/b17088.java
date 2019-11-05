package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b17088 {

	public static boolean checkSequence(int[] arr) {
		if (arr.length == 1) {
			return true;
		} else {
			int diff = arr[1] - arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				if (diff != arr[i + 1] - arr[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void go(int idx, int num, int[] arr, int cnt) {
		if (idx == num) {
			if (checkSequence(arr)) {
				min = Math.min(min, cnt);
			}
			return;
		}
		int temp = arr[idx];
		arr[idx] = arr[idx] + 1;
		go(idx + 1, num, arr, cnt + 1);
		arr[idx] = temp;
		go(idx + 1, num, arr, cnt);
		arr[idx] = arr[idx] - 1;
		go(idx + 1, num, arr, cnt + 1);
		arr[idx] = temp;

	}

	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		go(0, n, arr, 0);
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}
