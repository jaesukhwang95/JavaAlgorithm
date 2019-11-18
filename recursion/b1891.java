package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b1891 {

	public static class Point {
		long x;
		long y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static long[] d = new long[51];

	public static Point numberToPoint(String str, int idx, long x, long y, long size) {
		if (size == 1) {
			return new Point(x, y);
		} else {
			if (str.charAt(idx) == '1') {
				return numberToPoint(str, idx + 1, x, y + size / 2, size / 2);
			} else if (str.charAt(idx) == '2') {
				return numberToPoint(str, idx + 1, x, y, size / 2);
			} else if (str.charAt(idx) == '3') {
				return numberToPoint(str, idx + 1, x + size / 2, y, size / 2);
			} else if (str.charAt(idx) == '4') {
				return numberToPoint(str, idx + 1, x + size / 2, y + size / 2, size / 2);
			}
		}
		return new Point(0, 0);
	}

	public static String pointToString(long xBase, long yBase, long x, long y, long size) {
		if (size == 1)
			return "";
		if (x < xBase + size / 2 && y < yBase + size / 2) {
			return "2" + pointToString(xBase, yBase, x, y, size / 2);
		} else if (x < xBase + size / 2 && y >= yBase + size / 2) {
			return "1" + pointToString(xBase, yBase + size / 2, x, y, size / 2);
		} else if (x >= xBase + size / 2 && y < yBase + size / 2) {
			return "3" + pointToString(xBase + size / 2, yBase, x, y, size / 2);
		} else if (x >= xBase + size / 2 && y >= yBase + size / 2) {
			return "4" + pointToString(xBase + size / 2, yBase + size / 2, x, y, size / 2);
		}
		return "String";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		d[0] = 1;
		for (int i = 1; i <= 50; i++) {
			d[i] = d[i - 1] * 2L;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		String start = st.nextToken();
		st = new StringTokenizer(br.readLine());
		long distY = Long.parseLong(st.nextToken());
		long distX = Long.parseLong(st.nextToken());
		Point p = numberToPoint(start, 0, 0, 0, d[size]);
		long nx = p.x - distX;
		long ny = p.y + distY;
		if (0 <= nx && nx < d[size] && 0 <= ny && ny < d[size]) {
			System.out.println(pointToString(0, 0, nx, ny, d[size]));
		} else {
			System.out.println(-1);
		}
	}
}
