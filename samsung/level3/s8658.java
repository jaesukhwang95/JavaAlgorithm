package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s8658 {

	public static boolean[][] p;
	public static char[][] arr = new char[101][101];

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < arr.length; i++) {
				int el = arr[i];
				int sum = 0;
				while (true) {
					sum += el % 10;
					el = el / 10;
					if (el == el / 10) {
						break;
					}
				}
				arr[i] = sum;
			}
			Arrays.sort(arr);
			sb.append("#").append(num + 1).append(" ").append(arr[9]).append(" ").append(arr[0]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
