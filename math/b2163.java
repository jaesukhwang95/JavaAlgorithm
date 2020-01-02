package baekjoon.math;

import java.util.*;
import java.io.*;

public class b2163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = (n - 1) + n * (m - 1);
		System.out.println(ans);
	}
}
