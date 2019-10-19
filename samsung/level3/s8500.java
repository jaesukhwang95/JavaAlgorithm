package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s8500 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int sum = 0;
			for (int el : arr) {
				sum += el;
			}
			sum += arr.length;
			sum += arr[arr.length-1];
			sb.append("#").append(num + 1).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}