package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b16937 {
	public static class Sticker {
		int x;
		int y;

		Sticker(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int max = Integer.MIN_VALUE;

	public static int bigger(int x, int y) {
		if (x > y)
			return x;
		else
			return y;
	}

	public static void determineMax(int x1, int y1, int x2, int y2, int h, int w) {
		int biggerX = bigger(x1, x2);
		int biggerY = bigger(y1, y2);
		boolean signal = false;
		if (biggerX == x1) {
			if (x1 <= w && y1 + y2 <= h) {
				signal = true;
			}
			if (x1 <= h && y1 + y2 <= w) {
				signal = true;
			}
		} else {
			if (x2 <= w && y1 + y2 <= h)
				signal = true;
			if (x2 <= h && y1 + y2 <= w)
				signal = true;
		}
		if (biggerY == y1) {
			if (y1 <= w && x1 + x2 <= h)
				signal = true;
			if (y1 <= h && x1 + x2 <= w)
				signal = true;
		} else {
			if (y2 <= w && x1 + x2 <= h)
				signal = true;
			if (y2 <= h && x1 + x2 <= w)
				signal = true;
		}
		if (signal)
			max = Math.max(max, x1 * y1 + x2 * y2);
	}

	public static void determineXY(Sticker s1, Sticker s2, int h, int w) {
		int x1 = s1.x;
		int y1 = s1.y;
		int x2 = s2.x;
		int y2 = s2.y;
		determineMax(x1, y1, x2, y2, h, w);
		determineMax(y1, x1, x2, y2, h, w);
		determineMax(x1, y1, y2, x2, h, w);
		determineMax(y1, x1, y2, x2, h, w);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		ArrayList<Sticker> arr = new ArrayList<Sticker>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Sticker(x, y));
		}
		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				Sticker sticker1 = arr.get(i);
				Sticker sticker2 = arr.get(j);
				determineXY(sticker1, sticker2, h, w);
			}
		}
		if (max == Integer.MIN_VALUE)
			System.out.println(0);
		else
			System.out.println(max);
	}
}
