package baekjoon.graph;

import java.io.*;
import java.util.*;

public class b16928 {

	public static HashMap<Integer, Integer> pair = new HashMap<Integer, Integer>();
	public static HashSet<Integer> snakeSet = new HashSet<Integer>();
	public static HashSet<Integer> ladderSet = new HashSet<Integer>();
	public static boolean[] visit = new boolean[101];

	public static class info {
		int num;
		int cnt;

		info(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			pair.put(first, second);
			ladderSet.add(first);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			pair.put(first, second);
			snakeSet.add(first);
		}
		Queue<info> q = new LinkedList<info>();
		q.offer(new info(1, 0));
		visit[1] = true;
		while (!q.isEmpty()) {
			info info = q.poll();
			if (info.num == 100) {
				System.out.println(info.cnt);
				System.exit(0);
			}
			for (int i = 6; i > 0; i--) {
				if (info.num + i <= 100 && !visit[info.num + i]) {
					if (!ladderSet.contains(info.num + i) && !snakeSet.contains(info.num + i)) {
						visit[info.num + i] = true;
						q.offer(new info(info.num + i, info.cnt + 1));
					}
					if (snakeSet.contains(info.num + i)) {
						visit[pair.get(info.num + i)] = true;
						q.offer(new info(pair.get(info.num + i), info.cnt + 1));
					}
					if (ladderSet.contains(info.num + i)) {
						visit[pair.get(info.num + i)] = true;
						q.offer(new info(pair.get(info.num + i), info.cnt + 1));
					}
				}
			}
		}
	}
}
