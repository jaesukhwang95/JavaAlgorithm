package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b17779 {

	public static int min = Integer.MAX_VALUE;

	public static void initializeDistrict(int[][] district, int num) {
		for (int i = 1; i <= num; i++)
			for (int j = 1; j <= num; j++)
				district[i][j] = 0;
	}

	public static void makeDistrict(int x, int y, int d1, int d2, int[][] district, int num, int[][] population) {
		initializeDistrict(district, num);
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				if (district[i][j] != 5)
					district[i][j] = getDistrictNumber(i, j, d1, d2, x, y, num);
			}
		}
		getDifference(district, num, population);
	}

	public static void getDifference(int[][] district, int num, int[][] population) {
		int[] count = new int[5];
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				if (district[i][j] - 1 < 0)
					return;
				count[district[i][j] - 1] += population[i][j];
			}
		}
		Arrays.sort(count);
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0)
				return;
		}
		min = Math.min(min, count[4] - count[0]);
	}

	public static int getDistrictNumber(int r, int c, int d1, int d2, int x, int y, int num) {
		if (x + y <= r + c && r + c <= x + y + 2 * d2 && x - y <= r - c && r - c <= x - y + 2 * d1)
			return 5;
		else if (1 <= r && r < x + d1 && 1 <= c && c <= y)
			return 1;
		else if (1 <= r && r <= x + d2 && y < c && c <= num)
			return 2;
		else if (x + d1 <= r && r <= num && 1 <= c && c < y - d1 + d2)
			return 3;
		else if (x + d2 < r && r <= num && y - d1 + d2 <= c && c <= num)
			return 4;
		else
			return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] population = new int[num + 1][num + 1];

		for (int i = 1; i <= num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= num; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] district = new int[num + 1][num + 1];
		for (int d1 = 1; d1 <= num; d1++)
			for (int d2 = 1; d2 <= num; d2++)
				for (int x = 1; x <= num; x++)
					for (int y = 1; y <= num; y++) {
						if (x + d1 + d2 <= num && 1 <= y - d1 && y < y + d2 && y + d2 <= num)
							makeDistrict(x, y, d1, d2, district, num, population);
					}

		System.out.println(min);
	}
}
