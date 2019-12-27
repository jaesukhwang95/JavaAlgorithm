package baekjoon.math;

import java.util.*;
import java.io.*;

public class b2166 {
	public static class Point {
		long x;
		long y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static long formula(long x1, long y1, long x2, long y2, long x3, long y3) {
		return ((x1 * y2 - y1 * x2) + (x2 * y3 - y2 * x3) + (x3 * y1 - y3 * x1));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Point[] arr = new Point[num];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}
		long sum = 0;
		for (int i = 0; i < num - 2; i++) {
			sum = sum + formula(arr[0].x, arr[0].y, arr[i + 1].x, arr[i + 1].y, arr[i + 2].x, arr[i + 2].y);
		}
		sum = Math.abs(sum);
		System.out.println(String.format("%.1f", sum / (2.0)));
	}
}
