package baekjoon.graph;

import java.io.*;
import java.util.*;

public class b1963 {

	public static boolean[] notPrime = new boolean[10000];
	public static boolean[] visit = new boolean[10000];

	public static void makePrime() {
		for (int i = 2; i < 10000; i++) {
			if (!notPrime[i]) {
				for (int j = 2 * i; j < 10000; j = j + i) {
					notPrime[j] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		makePrime();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			for (int i = 0; i < 10000; i++)
				visit[i] = false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int ans = 0;
			boolean signal = true;
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(start);
			q.offer(0);
			visit[start] = true;
			while (!q.isEmpty()) {
				int num = q.poll();
				int cnt = q.poll();
				if (num == end) {
					ans = cnt;
					signal = false;
				}
				int first = num / 1000;
				int second = num / 100 % 10;
				int third = num / 10 % 10;
				int fourth = num % 10;

				int numWithNewFirst = num - first * 1000;
				for (int i = 1; i < 10; i++) {
					int new1 = numWithNewFirst + i * 1000;
					if (!visit[new1] && !notPrime[new1]) {
						visit[new1] = true;
						q.offer(new1);
						q.offer(cnt + 1);
					}
				}

				int numWithNewSecond = num - second * 100;
				for (int i = 0; i < 10; i++) {
					int new2 = numWithNewSecond + i * 100;
					if (!visit[new2] && !notPrime[new2]) {
						visit[new2] = true;
						q.offer(new2);
						q.offer(cnt + 1);
					}
				}

				int numWithNewThird = num - third * 10;
				for (int i = 0; i < 10; i++) {
					int new3 = numWithNewThird + i * 10;
					if (!visit[new3] && !notPrime[new3]) {
						visit[new3] = true;
						q.offer(new3);
						q.offer(cnt + 1);
					}
				}

				int numWithNewFourth = num - fourth;
				for (int i = 0; i < 10; i++) {
					int new4 = numWithNewFourth + i;
					if (!visit[new4] && !notPrime[new4]) {
						visit[new4] = true;
						q.offer(new4);
						q.offer(cnt + 1);
					}
				}
			}
			if (!signal) {
				System.out.println(ans);
			} else {
				System.out.println("Impossible");
			}
		}
	}
}
