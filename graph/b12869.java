package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b12869 {

	public static int[][] twoDamage = { { 9, 3 }, { 3, 9 } };
	public static int[][] threeDamage = { { 1, 3, 9 }, { 1, 9, 3 }, { 3, 1, 9 }, { 3, 9, 1 }, { 9, 1, 3 },
			{ 9, 3, 1 } };

	public static int attackTwo(int[] scvHealth, int maxHealth) {
		int cnt = 0;
		boolean[][] visit = new boolean[maxHealth + 1][maxHealth + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < 2; i++) {
			q.offer(scvHealth[i]);
		}
		q.offer(cnt);
		visit[scvHealth[0]][scvHealth[1]] = true;
		int nowCnt = 0;
		Loop: while (!q.isEmpty()) {
			int[] polledScvHealth = new int[2];
			for (int i = 0; i < 2; i++)
				polledScvHealth[i] = q.poll();
			nowCnt = q.poll();
			for (int i = 0; i < 2; i++) {
				if (polledScvHealth[0] > 0 || polledScvHealth[1] > 0) {
					if (polledScvHealth[0] - twoDamage[i][0] <= 0 && polledScvHealth[1] - twoDamage[i][1] <= 0) {
						break Loop;
					}
					if (!visit[polledScvHealth[0] - twoDamage[i][0] <= 0 ? 0
							: polledScvHealth[0] - twoDamage[i][0]][polledScvHealth[1] - twoDamage[i][1] <= 0 ? 0
									: polledScvHealth[1] - twoDamage[i][1]]) {
						q.offer(polledScvHealth[0] - twoDamage[i][0]);
						q.offer(polledScvHealth[1] - twoDamage[i][1]);
						q.offer(nowCnt + 1);
						visit[polledScvHealth[0] - twoDamage[i][0] <= 0 ? 0
								: polledScvHealth[0] - twoDamage[i][0]][polledScvHealth[1] - twoDamage[i][1] <= 0 ? 0
										: polledScvHealth[1] - twoDamage[i][1]] = true;
					}
				}
			}
		}
		return nowCnt + 1;
	}

	public static int attackThree(int[] scvHealth, int maxHealth) {
		int cnt = 0;
		boolean[][][] visit = new boolean[maxHealth + 1][maxHealth + 1][maxHealth + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < 3; i++) {
			q.offer(scvHealth[i]);
		}
		q.offer(cnt);
		visit[scvHealth[0]][scvHealth[1]][scvHealth[2]] = true;
		int nowCnt = 0;
		Loop: while (!q.isEmpty()) {
			int[] polledScvHealth = new int[3];
			for (int i = 0; i < 3; i++)
				polledScvHealth[i] = q.poll();
			nowCnt = q.poll();
			for (int i = 0; i < 6; i++) {
				if (polledScvHealth[0] > 0 || polledScvHealth[1] > 0 || polledScvHealth[2] > 0) {
					if (polledScvHealth[0] - threeDamage[i][0] <= 0 && polledScvHealth[1] - threeDamage[i][1] <= 0
							&& polledScvHealth[2] - threeDamage[i][2] <= 0) {
						break Loop;
					}
					if (!visit[polledScvHealth[0] - threeDamage[i][0] <= 0 ? 0
							: polledScvHealth[0] - threeDamage[i][0]][polledScvHealth[1] - threeDamage[i][1] <= 0 ? 0
									: polledScvHealth[1] - threeDamage[i][1]][polledScvHealth[2]
											- threeDamage[i][2] <= 0 ? 0 : polledScvHealth[2] - threeDamage[i][2]]) {
						q.offer(polledScvHealth[0] - threeDamage[i][0]);
						q.offer(polledScvHealth[1] - threeDamage[i][1]);
						q.offer(polledScvHealth[2] - threeDamage[i][2]);
						q.offer(nowCnt + 1);
						visit[polledScvHealth[0] - threeDamage[i][0] <= 0 ? 0
								: polledScvHealth[0] - threeDamage[i][0]][polledScvHealth[1] - threeDamage[i][1] <= 0
										? 0
										: polledScvHealth[1] - threeDamage[i][1]][polledScvHealth[2]
												- threeDamage[i][2] <= 0 ? 0
														: polledScvHealth[2] - threeDamage[i][2]] = true;
					}
				}
			}
		}
		return nowCnt + 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] scvHealth = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int maxHealth = Integer.MIN_VALUE;
		for (int i = 0; i < num; i++) {
			scvHealth[i] = Integer.parseInt(st.nextToken());
			maxHealth = Math.max(maxHealth, scvHealth[i]);
		}
		int ans = 0;
		if (num == 1) {
			ans = maxHealth / 9 + 1;
			if (maxHealth % 9 == 0)
				ans = ans - 1;
		}
		if (num == 2) {
			ans = attackTwo(scvHealth, maxHealth);
		}
		if (num == 3) {
			ans = attackThree(scvHealth, maxHealth);
		}
		System.out.println(ans);
	}
}
