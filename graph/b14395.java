package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b14395 {

	public static class Info {
		long num;
		String str;

		Info(long num, String str) {
			this.num = num;
			this.str = str;
		}
	}

	public static char[] op = { '*', '+', '-', '/' };

	public static long operation(int i, long num) {
		if (i == 0) {
			return num * num;
		} else if (i == 1) {
			return num + num;
		} else if (i == 2) {
			return num - num;
		} else if (i == 3) {
			return num / num;
		}
		return -1;
	}

	public static ArrayList<String> ans = new ArrayList<String>();
	public static HashSet<Long> set = new HashSet<Long>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long start = Long.parseLong(st.nextToken());
		long end = Long.parseLong(st.nextToken());
		if (start == end) {
			System.out.println(0);
			System.exit(0);
		}
		Queue<Info> q = new LinkedList<Info>();
		String startStr = "";
		q.offer(new Info(start, startStr));
		set.add(start);
		while (!q.isEmpty()) {
			Info info = q.poll();
			if (info.num == end) {
				ans.add(info.str);
			}
			if (info.num != 0) {
				for (int i = 0; i < 4; i++) {
					long result = operation(i, info.num);
					if (!set.contains(result) && info.num != 0) {
						set.add(result);
						q.offer(new Info(result, info.str + op[i]));
					}
				}
			}
		}
		if (ans.size() == 0) {
			System.out.println(-1);
		} else {
			int min = Integer.MAX_VALUE;
			for (String s : ans) {
				if (s.length() < min) {
					min = s.length();
				}
			}
			for (String s : ans) {
				if (s.length() != min) {
					ans.remove(s);
				}
			}
			Collections.sort(ans);
			System.out.println(ans.get(0));
		}
	}
}
