package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

public class b2294 {

	public static int[] d = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= 10000; i++)
			d[i] = 100001;
		d[0] = 0;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i <= 10000; i++) {
				if (i + arr[j] > 10000)
					break;
				d[i + arr[j]] = Math.min(d[i] + 1, d[i + arr[j]]);
			}
		}
		if(d[k] == 100001)
			System.out.println(-1);
		else
			System.out.println(d[k]);
	}
}
