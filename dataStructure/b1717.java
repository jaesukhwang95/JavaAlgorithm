package baekjoon.dataStructure;


import java.util.*;
import java.io.*;

public class b1717 {

	public static int[] group;

	public static int find(int num) {
		if (num == group[num])
			return num;
		else
			return group[num] = find(group[num]);
	}

	public static void union(int first, int second) {
		int firstGroup = find(first);
		int secondGroup = find(second);
		if (firstGroup != secondGroup) {
			group[secondGroup] = firstGroup;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		group = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			group[i] = i;
		}
		for (int i = 0; i < total; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			if (command == 1) {
				if (find(first) == find(second))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			} else {
				union(first, second);
			}
		}
		System.out.print(sb.toString());
	}
}
