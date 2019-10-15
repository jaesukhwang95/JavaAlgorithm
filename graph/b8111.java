package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b8111 {

	public static int[] prev;
	public static int[] now;
	public static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder ans = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			if (n == 1)
				sb.append(1).append("\n");
			else {
				prev = new int[n];
				now = new int[n];
				visit = new boolean[n];
				Queue<Integer> q = new LinkedList<Integer>();
				prev[1] = -1;
				now[1] = 1;
				visit[1] = true;
				q.offer(1);
				while (!q.isEmpty()) {
					int num = q.poll();
					for (int i = 0; i < 2; i++) {
						int r = (num * 10 + i) % n;
						if (!visit[r]) {
							visit[r] = true;
							now[r] = i;
							prev[r] = num;
							q.offer(r);
						}
					}
				}
				if (!visit[0]) {
					sb.append("BRAK").append("\n");
				} else {
					int i = 0;
					while (true) {
						sb.insert(0, now[i]);
						i = prev[i];
						if (prev[i] == -1) {
							sb.insert(0, 1);
							sb.append("\n");
							break;

						}
					}
				}
			}
			ans.append(sb);
		}
		bw.write(ans.toString());
		bw.close();
		br.close();
	}
}
