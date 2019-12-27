package baekjoon.math;

import java.util.*;
import java.io.*;

public class b11758 {

	public static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static long formula(int x1, int y1, int x2, int y2, int x3, int y3) {
		long ans = (x1 * y2 - x2 * y1) + (x2 * y3 - y2 * x3) + (x3 * y1 - x1 * y3);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Point a = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Point b = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Point c = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		long ans = formula(a.x, a.y, b.x, b.y, c.x, c.y);
		if (ans < 0)
			System.out.println(-1);
		else if (ans == 0)
			System.out.println(0);
		else
			System.out.println(1);
	}
}
