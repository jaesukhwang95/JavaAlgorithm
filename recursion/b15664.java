package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b15664 {

	public static int n, m;
	public static ArrayList<Integer> arr;
	public static int[] cnt = new int[10001];
	public static int[] ans;
	public static StringBuilder a = new StringBuilder();

	public static void go(int idx, int start) {
		if (idx == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(ans[i]);
				if (i != m - 1)
					sb.append(" ");
			}
			sb.append("\n");
			a.append(sb.toString());
			return;
		}
		for (int i = start; i < arr.size(); i++) {
			if (cnt[arr.get(i)] > 0) {
				cnt[arr.get(i)]--;
				ans[idx] = arr.get(i);
				go(idx + 1, i);
				ans[idx] = 0;
				cnt[arr.get(i)]++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] tmp = new int[n];
		ans = new int[m];

		TreeSet<Integer> set = new TreeSet<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tmp[i] = Integer.parseInt(st.nextToken());
			cnt[tmp[i]]++;
		}
		Arrays.sort(tmp);
		for (int i = 0; i < n; i++) {
			set.add(tmp[i]);
		}
		arr = new ArrayList<Integer>(set);
		go(0, 0);
		bw.write(a.toString());
		bw.close();
		br.close();
	}
}
