package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class b12970 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean signal = false;
		for (int a = 0; a < n; a++) {
			int b = n - a;
			if (a * b < k)
				continue;

			int[] ABeforeB = new int[b + 1];
			for (int i = 0; i < a; i++) {
				int min = Math.min(k, b);
				ABeforeB[min]++;
				k = k - min;
			}

			StringBuilder ans = new StringBuilder();

			for (int i = b; i >= 0; i--) {
				for (int j = 0; j < ABeforeB[i]; j++)
					ans.append("A");
				if (i > 0)
					ans.append("B");
			}
			signal = true;
			System.out.println(ans);
			System.exit(0);
		}
		if (!signal) {
			System.out.println(-1);
		}
	}
}
