package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class b2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int max = 0;

		if (n >= 2 * m) {
			max = m;
			n = n - 2 * m;
			m = 0;
			k = k - n - m;
			if (k < 0)
				k = 0;
			if (k % 3 == 0)
				max = max - ((k / 3));
			else
				max = max - ((k / 3) + 1);
		} else {
			max = n / 2;
			n = n - 2 * max;
			m = m - max;
			k = k - n - m;
			if (k < 0)
				k = 0;
			if (k % 3 == 0)
				max = max - ((k / 3));
			else
				max = max - ((k / 3) + 1);
		}
		System.out.println(max);
	}
}