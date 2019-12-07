package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b5014 {

	public static class Elevator {
		int floor;
		int button;

		Elevator(int floor, int button) {
			this.floor = floor;
			this.button = button;
		}
	}

	public static int move(int top, int start, int finish, int up, int down, boolean[] visit) {
		Queue<Elevator> q = new LinkedList<Elevator>();
		q.offer(new Elevator(start, 0));
		int cnt = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Elevator e = q.poll();
			int floor = e.floor;
			int button = e.button;
			if (floor == finish) {
				cnt = button;
				break;
			}
			if (floor + up <= 1000000 && !visit[floor + up] && up != 0) {
				visit[floor + up] = true;
				q.offer(new Elevator(floor + up, button + 1));
			}
			if (1 <= floor - down && !visit[floor - down] && down != 0) {
				visit[floor - down] = true;
				q.offer(new Elevator(floor - down, button + 1));
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int top = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int finish = Integer.parseInt(st.nextToken());
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[1000001];
		int ans = move(top, start, finish, up, down, visit);
		if (ans == Integer.MAX_VALUE)
			System.out.println("use the stairs");
		else
			System.out.println(ans);
	}
}
