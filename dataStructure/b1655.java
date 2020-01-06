package baekjoon.dataStructure;

import java.util.*;
import java.io.*;

public class b1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		Queue<Integer> maxHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < total; i++) {
			int num = Integer.parseInt(br.readLine());
			minHeap.add(num);
			if (i % 2 == 0) {
				maxHeap.offer((-1) * minHeap.poll());
			} else {
				if ((-1) * maxHeap.peek() > num) {
					minHeap.offer((-1) * maxHeap.poll());
					maxHeap.offer((-1) * minHeap.poll());
				}
			}
			sb.append((-1) * maxHeap.peek() + "\n");
		}
		System.out.print(sb.toString());
	}
}
