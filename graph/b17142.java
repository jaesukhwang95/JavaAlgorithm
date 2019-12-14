package baekjoon.graph;

import java.util.*;
import java.io.*;

//Activated = -1;
//Not Acitvated = -2;
//wall = -3;

public class b17142 {

	public static class Virus {
		int x;
		int y;
		int time;

		Virus(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void spreadVirus(int[] indexArray, ArrayList<Virus> virusList, int[][] lab, int n) {
		Queue<Virus> q = new LinkedList<Virus>();
		for (int i = 0; i < indexArray.length; i++) {
			Virus v = virusList.get(indexArray[i]);
			q.offer(v);
			lab[v.x][v.y] = -1;
		}
		while (!q.isEmpty()) {
			Virus p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (lab[nx][ny] == -2) {
						lab[nx][ny] = -1;
						q.offer(new Virus(nx, ny, p.time + 1));
					}
					if (lab[nx][ny] == 0) {
						lab[nx][ny] = p.time + 1;
						q.offer(new Virus(nx, ny, p.time + 1));
					}
				}
			}
		}
	}

	public static void makeSameArray(int[][] arr1, int[][] arr2, int n) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				arr1[i][j] = arr2[i][j];
			}
	}

	public static void getMinimumTime(int[] indexArray, int a, int b, int index, int target, ArrayList<Virus> virusList,
			int n) {
		if (b == 0) {
			int[][] lab = new int[n][n];
			makeSameArray(lab, originalLab, n);
			spreadVirus(indexArray, virusList, lab, n);
			boolean signal = false;
			int localMinimum = Integer.MIN_VALUE;
			Loop: for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					if (lab[i][j] == 0) {
						signal = true;
						break Loop;
					} else {
						localMinimum = Math.max(localMinimum, lab[i][j]);
					}
				}
			if (!signal) {
				minimumTime = Math.min(minimumTime, localMinimum);
			}
			return;
		}
		if (target == a)
			return;
		indexArray[index] = target;
		getMinimumTime(indexArray, a, b - 1, index + 1, target + 1, virusList, n);
		getMinimumTime(indexArray, a, b, index, target + 1, virusList, n);
	}

	public static int[][] originalLab;
	public static int minimumTime = Integer.MAX_VALUE;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		originalLab = new int[n][n];
		ArrayList<Virus> virusList = new ArrayList<Virus>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				originalLab[i][j] = Integer.parseInt(st.nextToken());
				if (originalLab[i][j] == 2) {
					virusList.add(new Virus(i, j, 0));
					originalLab[i][j] = -2;
				}
				if (originalLab[i][j] == 1)
					originalLab[i][j] = -3;
			}
		}
		int[] indexArray = new int[m];
		getMinimumTime(indexArray, virusList.size(), m, 0, 0, virusList, n);
		if (minimumTime == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			if (minimumTime == -1)
				minimumTime = 0;
			System.out.println(minimumTime);

		}
	}
}