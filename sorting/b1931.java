package baekjoon.sorting;

import java.io.*;
import java.util.*;

public class b1931 {

	public static class Time implements Comparable<Time> {
		private int start;
		private int end;

		Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time a) {
			if (this.end < a.end)
				return -1;
			else if (this.end == a.end) {
				if (this.start < a.start)
					return -1;
				else
					return 1;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int cnt = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Time> arr = new ArrayList<Time>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.add(new Time(start, end));
		}
		Collections.sort(arr);
		int j = 0;
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(j).end > arr.get(i).start) {
				continue;
			} else {
				j = i;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}