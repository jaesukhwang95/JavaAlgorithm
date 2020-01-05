package baekjoon.dataStructure;

import java.util.*;
import java.io.*;

public class b1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < total; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (q.isEmpty())
					sb.append(0 + "\n");
				else
					sb.append(q.poll() + "\n");
			} else
				q.offer(num);

		}
		System.out.print(sb.toString());
	}
}
