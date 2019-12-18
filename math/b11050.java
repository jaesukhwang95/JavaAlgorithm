package baekjoon.math;

import java.io.*;
import java.util.*;

public class b11050 {

	public static int factorial(int num) {
		if (num == 0)
			return 1;
		if (num == 1)
			return 1;
		return num * factorial(num - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ans = factorial(n) / factorial(k) / factorial(n - k);
		System.out.println(ans);
	}
}
