package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b15663 {

	public static void go(int idx) {
		if (idx == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(ans[i]);
				if (i != m - 1)
					sb.append(" ");
			}
			sb.append("\n");
			s.append(sb.toString());
			return;
		}
		for (int i = 0; i < arr.size(); i++) {
			if (cnt[arr.get(i)] > 0) {
				ans[idx] = arr.get(i);
				cnt[arr.get(i)]--;
				go(idx + 1);
				ans[idx] = 0;
				cnt[arr.get(i)]++;
			}
		}
	}

	public static int n, m;
	public static int[] tmp;
	public static int[] cnt = new int[10001];
	public static TreeSet<Integer> set = new TreeSet<Integer>();
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static int[] ans;
	public static StringBuilder s = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tmp = new int[n];
		ans = new int[m];
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
		go(0);
		bw.write(s.toString());
		bw.close();
		br.close();
	}
}
