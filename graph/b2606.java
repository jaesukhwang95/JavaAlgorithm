package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b2606 {

	public static int count = 0;

	public static void findCount(int idx, int num, boolean[][] adjacent, boolean[] visit) {
		for (int i = 2; i <= num; i++) {
			if (adjacent[idx][i] && !visit[i]) {
				visit[i] = true;
				count++;
				findCount(i, num, adjacent, visit);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		boolean[][] adjacent = new boolean[num + 1][num + 1];
		int total = Integer.parseInt(br.readLine());
		for (int i = 0; i < total; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			adjacent[first][second] = true;
			adjacent[second][first] = true;
		}
		boolean[] visit = new boolean[num + 1];
		visit[1] = true;
		findCount(1, num, adjacent, visit);
		System.out.println(count);
	}
}
