package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class b16917 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int seasoned = Integer.parseInt(st.nextToken());
		int fried = Integer.parseInt(st.nextToken());
		int half = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int much = x > y ? x : y;
		int less = x < y ? x : y;

		int ans = 0;

		if (2 * half < seasoned + fried) {
			ans += half * 2 * less;
			if (x == much) {
				ans += seasoned * (much - less);
			} else {
				ans += fried * (much - less);
			}

			if (2 * half * much < ans) {
				ans = 2 * half * much;
			}
		} else {
			ans += seasoned * x + fried * y;
		}
		System.out.println(ans);
	}
}
