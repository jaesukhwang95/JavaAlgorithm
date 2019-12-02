package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b16953 {

	public static class Pair {
		long num;
		int cnt;

		Pair(long num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		Queue<Pair> q = new LinkedList<Pair>();
		int cnt = 0;
		q.offer(new Pair(a, cnt));
		int ans = Integer.MAX_VALUE;
		boolean signal = false;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			long num = p.num;
			int count = p.cnt;
			if (num == b) {
				signal = true;
				ans = count;
				break;
			}
			if (num * 10 + 1 <= 1000000000 && num * 10 + 1 >= 1) {
				q.offer(new Pair(num * 10 + 1, count + 1));
			}
			if (num * 2 <= 1000000000 && num * 2 >= 1) {
				q.offer(new Pair(num * 2, count + 1));
			}
		}
		if (!signal) {
			System.out.println(-1);
		} else {
			System.out.println(ans + 1);
		}
	}
}