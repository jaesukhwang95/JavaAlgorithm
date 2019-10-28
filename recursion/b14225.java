package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b14225 {

	public static void go(int idx, int sum, int[] arr, int n) {
		if (idx == n) {
			set.add(sum);
			return;
		}
		go(idx + 1, sum + arr[idx], arr, n);
		go(idx + 1, sum, arr, n);
	}

	public static HashSet<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		go(0, 0, arr, n);
		ArrayList<Integer> ans = new ArrayList<Integer>(set);
		Collections.sort(ans);
		int num = 0;
		boolean signal = true;
		for (int i = 0; i < ans.size() - 1; i++) {
			if (ans.get(i + 1) == ans.get(i) + 1)
				continue;
			{
				signal = false;
				num = ans.get(i) + 1;
				break;
			}
		}
		if (signal)
			num = ans.get(ans.size() - 1) + 1;
		System.out.println(num);
	}
}
