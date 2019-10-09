package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b15666 {

	public static int n, m;
	public static int[] cnt;
	public static ArrayList<Integer> arr;
	public static int[] el;
	public static StringBuilder ans = new StringBuilder();

	public static void go(int idx, int start) {
		if (idx == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(el[i]);
				if (i != m - 1)
					sb.append(" ");
			}
			sb.append("\n");
			ans.append(sb);
			return;
		}
		for (int i = start; i < arr.size(); i++) {
			el[idx] = arr.get(i);
			go(idx + 1, i);
			el[idx] = 0;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] tmp = new int[n];
		TreeSet<Integer> set = new TreeSet<Integer>();
		cnt = new int[10001];
		el = new int[m];
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
		bw.write(ans.toString());
		bw.close();
		br.close();
	}

}
