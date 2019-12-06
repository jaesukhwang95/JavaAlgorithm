package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class b12931 {

	public static int findCounts(int[] ans) {
		int cnt = 0;
		while (true) {
			for (int i = 0; i < ans.length; i++) {
				if (ans[i] % 2 != 0) {
					ans[i]--;
					cnt++;
				}
			}
			if (checkSameArray(ans))
				break;
			for (int i = 0; i < ans.length; i++) {
				ans[i] = ans[i] / 2;
			}
			cnt++;
			if (checkSameArray(ans))
				break;
		}
		return cnt;
	}

	public static boolean checkSameArray(int[] ans) {
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] ans = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = findCounts(ans);
		System.out.println(cnt);
	}
}