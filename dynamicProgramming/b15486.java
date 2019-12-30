package baekjoon.dynamicProgramming;

import java.util.*;
import java.io.*;

public class b15486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] time = new int[num + 1];
		int[] price = new int[num + 1];
		int[] ans = new int[num + 1];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 0; i <= num; i++) {
			max = Math.max(max, ans[i]);
			if (i + time[i] < num + 1)
				ans[i + time[i]] = Math.max(max + price[i], ans[i + time[i]]);
		}
		System.out.println(max);
	}
}
