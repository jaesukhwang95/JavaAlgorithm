package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

public class b2293 {

	public static int[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		d = new int[100001];
		for (int j = 0; j < n; j++) {
			d[0] = 1;
		}
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int j = 0; j < n; j++) {
			for (int i = 0; i <= 100000; i++) {
				if (i + arr[j] > 100000)
					break;
				d[i + arr[j]] = d[i + arr[j]] + d[i];
			}
		}
		System.out.println(d[k]);
	}
}