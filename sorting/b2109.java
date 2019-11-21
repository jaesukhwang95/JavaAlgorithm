package baekjoon.sorting;

import java.io.*;
import java.util.*;

public class b2109 {

	public static class Lecture implements Comparable<Lecture> {
		private int day;
		private int pay;

		Lecture(int pay, int day) {
			this.day = day;
			this.pay = pay;
		}

		@Override
		public int compareTo(Lecture a) {
			if (this.pay > a.pay)
				return -1;
			else if (this.pay == a.pay) {
				if (this.day < a.day)
					return -1;
				else
					return 1;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Lecture[] arr = new Lecture[n];
		boolean[] visit = new boolean[10001];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			arr[i] = new Lecture(pay, day);
		}
		Arrays.sort(arr);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (!visit[arr[i].day]) {
				sum += arr[i].pay;
				visit[arr[i].day] = true;
			} else {
				for (int j = arr[i].day - 1; j >= 1; j--) {
					if (!visit[j]) {
						sum += arr[i].pay;
						visit[j] = true;
						break;
					}
				}
			}
		}
		System.out.println(sum);
	}
}