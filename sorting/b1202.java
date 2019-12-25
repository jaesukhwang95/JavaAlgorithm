package baekjoon.sorting;

import java.util.*;
import java.io.*;

public class b1202 {

	public static class Jewerly implements Comparable<Jewerly> {
		int weight;
		int price;

		Jewerly(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Jewerly a) {
			if (this.weight < a.weight)
				return -1;
			else if (this.weight == a.weight)
				return 0;
			else
				return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int jewerlyNum = Integer.parseInt(st.nextToken());
		int bagNum = Integer.parseInt(st.nextToken());
		Jewerly[] jewerlyArr = new Jewerly[jewerlyNum];
		long maxValue = 0;
		for (int i = 0; i < jewerlyNum; i++) {
			st = new StringTokenizer(br.readLine());
			jewerlyArr[i] = new Jewerly(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int[] bagArr = new int[bagNum];
		for (int i = 0; i < bagNum; i++) {
			bagArr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(jewerlyArr);
		Arrays.sort(bagArr);
		Queue<Integer> q = new PriorityQueue<Integer>();
		int j = 0;
		for (int i = 0; i < bagNum; i++) {
			while (j < jewerlyNum && jewerlyArr[j].weight <= bagArr[i]) {
				q.offer(-jewerlyArr[j].price);
				j++;
			}
			if (!q.isEmpty()) {
				maxValue = maxValue - q.poll();
			}
		}
		System.out.println(maxValue);
	}
}
