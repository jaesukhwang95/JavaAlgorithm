package baekjoon.bruteForce;

import java.io.*;
import java.util.*;

public class b15686 {

	public static class ChickenHouse {
		int x;
		int y;

		ChickenHouse(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class House {
		int x;
		int y;

		House(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void findMinimumChickenDistance(int[] idxArray, int n, int r, int index, int target) {
		if (r == 0) {
			int sum = 0;
			for (House j : houseList) {
				int localMin = Integer.MAX_VALUE;
				for (int i : idxArray) {
					localMin = Math.min(localMin,
							distance(chickenHouseList.get(i).x, chickenHouseList.get(i).y, j.x, j.y));
				}
				sum = sum + localMin;
			}
			min = Math.min(sum, min);
			return;
		}
		if (target == n)
			return;
		idxArray[index] = target;
		findMinimumChickenDistance(idxArray, n, r - 1, index + 1, target + 1);
		findMinimumChickenDistance(idxArray, n, r, index, target + 1);

	}

	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static ArrayList<ChickenHouse> chickenHouseList;
	public static ArrayList<House> houseList;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		chickenHouseList = new ArrayList<ChickenHouse>();
		houseList = new ArrayList<House>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chickenHouseList.add(new ChickenHouse(i, j));
				} else if (map[i][j] == 1) {
					houseList.add(new House(i, j));
				}
			}
		}
		int[] idxArray = new int[m];
		findMinimumChickenDistance(idxArray, chickenHouseList.size(), m, 0, 0);
		System.out.println(min);
	}
}
