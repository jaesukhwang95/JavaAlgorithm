package baekjoon.dataStructure;

import java.util.*;
import java.io.*;

public class b11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < total; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (q.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(q.poll() * (-1) + "\n");
				}
			} else {
				q.offer(num * (-1));
			}
		}
		System.out.print(sb.toString());
	}
}
