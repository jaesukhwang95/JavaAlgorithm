package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s1208 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int num = 0; num < 10; num++) {
			int[] arr = new int[100];
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			while (dump-- > 0) {
				Arrays.sort(arr);
				if (Math.abs(arr[0] - arr[99]) <= 1)
					break;
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr);
			sb.append("#").append(num + 1).append(" ").append(Math.abs(arr[0] - arr[99])).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}