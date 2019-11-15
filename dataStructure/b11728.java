package baekjoon.dataStructure;

import java.util.*;
import java.io.*;

public class b11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int lenA = Integer.parseInt(st.nextToken());
		int lenB = Integer.parseInt(st.nextToken());
		int[] ans = new int[lenA + lenB];
		st = new StringTokenizer(br.readLine());
		int k = 0;
		for (int i = 0; i < lenA; i++) {
			ans[k++] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < lenB; i++) {
			ans[k++] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ans);
		for (int i : ans)
			sb.append(i + " ");
		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb.toString());
	}
}
