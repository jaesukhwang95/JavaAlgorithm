package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class b1783 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (n == 1) {
			System.out.println(1);
		} else if (n == 2) {
			System.out.println(Math.min(4, (m + 1) / 2));
		} else if (m <= 6) {
			System.out.println(Math.min(4, m));
		} else {
			System.out.println(m - 2);
		}
	}
}