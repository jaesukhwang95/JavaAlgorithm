package baekjoon.sorting;

import java.util.*;
import java.io.*;

public class b16937 {
	public static class Sticker implements Comparable<Sticker> {
		int longer;
		int shorter;
		int num;

		Sticker(int longer, int shorter, int num) {
			this.longer = longer;
			this.shorter = shorter;
			this.num = num;
		}

		@Override
		public int compareTo(Sticker a) {
			if (this.longer * this.shorter > a.longer * a.shorter)
				return -1;
			else {
				return 1;
			}
		}
	}

	public static int max = Integer.MIN_VALUE;

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
			if (x > y) {
				arr.add(new Sticker(x, y, i));
			} else {
				arr.add(new Sticker(y, x, i));
			}
		}
		Collections.sort(arr);
		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = i; j < arr.size(); j++) {
				Sticker sticker1 = arr.get(i);
				Sticker sticker2 = arr.get(j);
				if (sticker1.longer > sticker2.longer) {
					if ((sticker1.longer <= h && (sticker1.shorter + sticker2.shorter) <= w)
							|| (sticker1.longer <= w && (sticker1.shorter + sticker2.shorter) <= h)) {
						max = Math.max(max, sticker1.shorter * sticker1.longer + sticker2.shorter * sticker2.longer);
					}
				} else {
					if ((sticker2.longer <= h && (sticker1.shorter + sticker2.shorter) <= w)
							|| (sticker2.longer <= w && (sticker1.shorter + sticker2.shorter) <= h)) {
						max = Math.max(max, sticker1.shorter * sticker1.longer + sticker2.shorter * sticker2.longer);
					}
				}
			}
		}
		if (max == Integer.MIN_VALUE)
			System.out.println(0);
		else
			System.out.println(max);
	}
}
