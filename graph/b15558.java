package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b15558 {

	public static class Status {
		int line;
		int stage;
		int deadline;

		Status(int line, int stage, int deadline) {
			this.line = line;
			this.stage = stage;
			this.deadline = deadline;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char[][] lines = new char[2][n + 1];
		boolean[][] visit = new boolean[2][n + 1];
		for (int j = 0; j <= 1; j++) {
			String str = br.readLine();
			for (int i = 1; i <= n; i++) {
				lines[j][i] = str.charAt(i - 1);
			}
		}

		Queue<Status> q = new LinkedList<Status>();
		q.offer(new Status(0, 1, 0));
		visit[0][1] = true;
		boolean signal = false;
		while (!q.isEmpty()) {
			Status s = q.poll();
			int line = s.line;
			int nextLine = line == 1 ? 0 : 1;
			int stage = s.stage;
			int deadline = s.deadline;

			if (stage + k > n || stage > n) {
				signal = true;
				break;
			}
			if (lines[line][stage + 1] == '1' && !visit[line][stage + 1]) {
				q.offer(new Status(line, stage + 1, deadline + 1));
				visit[line][stage + 1] = true;
			}
			if (lines[line][stage - 1] == '1' && (stage - 1 > deadline + 1) && !visit[line][stage - 1]) {
				q.offer(new Status(line, stage - 1, deadline + 1));
				visit[line][stage - 1] = true;
			}
			if (lines[nextLine][stage + k] == '1' && !visit[nextLine][stage + k]) {
				q.offer(new Status(nextLine, stage + k, deadline + 1));
				visit[nextLine][stage + k] = true;
			}
		}
		if (signal)
			System.out.println(1);
		else
			System.out.println(0);
	}
}