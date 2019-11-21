package baekjoon.sorting;

import java.util.*;
import java.io.*;

public class b16936 {
	public static long countTwo(long num) {
		long cnt = 0;
		while (num % 2 == 0) {
			cnt++;
			num = num / 2;
		}
		return cnt;
	}

	public static long countThree(long num) {
		long cnt = 0;
		while (num % 3 == 0) {
			cnt++;
			num = num / 3;
		}
		return cnt;
	}

	public static class Number implements Comparable<Number> {
		long number;
		long two;
		long three;

		Number(long number, long two, long three) {
			this.number = number;
			this.two = two;
			this.three = three;
		}

		@Override
		public int compareTo(Number a) {
			if (this.three > a.three)
				return -1;
			else {
				if (this.two < a.two)
					return -1;
				else
					return 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Number> numList = new ArrayList<Number>();
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			numList.add(new Number(arr[i], countTwo(arr[i]), countThree(arr[i])));
		}
		Collections.sort(numList);
		for (int i = 0; i < n; i++)
			sb.append(numList.get(i).number + " ");
		sb.delete(sb.length() - 1, sb.length());
		sb.append("\n");
		bw.write(sb.toString());
		bw.close();
	}
}