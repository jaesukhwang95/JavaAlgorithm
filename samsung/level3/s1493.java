package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s1493 {

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static Pair intToPair(int num) {
		int x = 1;
		while ((x * x + x + 2) / 2 <= num) {
			x++;
		}
		int sum = x + 1;
		int diff = num - (x * x - x + 2) / 2;
		return new Pair(1 + diff, sum - 1 - diff);
	}

	public static int pairToInt(Pair p) {
		int x = p.x;
		int y = p.y;
		int end = x + y - 2;
		int sum = 0;
		for (int i = 1; i <= end; i++) {
			sum = sum + i;
		}
		sum = sum + x;
		return sum;
	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			Pair a = intToPair(p);
			Pair b = intToPair(q);
			ans = pairToInt(new Pair(a.x + b.x, a.y + b.y));
			sb.append("#").append(i + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}