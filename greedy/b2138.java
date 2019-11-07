package baekjoon.greedy;
import java.io.*;

public class b2138 {

	public static int flip(int x) {
		if (x == 1)
			return 0;
		else
			return 1;
	}

	public static void main(String[] args) throws IOException {
		int min = Integer.MAX_VALUE;
		boolean signal = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] prev1 = new int[n];
		int[] prev2 = new int[n];
		int[] next = new int[n];

		String str = br.readLine();
		for (int i = 0; i < n; i++) {
			prev1[i] = str.charAt(i) - '0';
			prev2[i] = prev1[i];
		}

		str = br.readLine();
		for (int i = 0; i < n; i++)
			next[i] = str.charAt(i) - '0';

		int cnt1 = 0;
		int cnt2 = 0;

		// first switch no click
		for (int i = 1; i < n - 1; i++) {
			if (prev1[i - 1] != next[i - 1]) {
				for (int j = i - 1; j <= i + 1; j++)
					prev1[j] = flip(prev1[j]);
				cnt1++;
			}
		}

		if (prev1[n - 2] == next[n - 2] && prev1[n - 1] == next[n - 1]) {
			min = Math.min(min, cnt1);
			signal = true;
		}
		if (prev1[n - 2] != next[n - 2] && prev1[n - 1] != next[n - 1]) {
			min = Math.min(min, cnt1 + 1);
			signal = true;
		}

		// first switch click
		prev2[0] = flip(prev2[0]);
		prev2[1] = flip(prev2[1]);
		cnt2++;

		for (int i = 1; i < n - 1; i++) {
			if (prev2[i - 1] != next[i - 1]) {
				for (int j = i - 1; j <= i + 1; j++)
					prev2[j] = flip(prev2[j]);
				cnt2++;
			}
		}

		if (prev2[n - 2] == next[n - 2] && prev2[n - 1] == next[n - 1]) {
			min = Math.min(min, cnt2);
			signal = true;
		}
		if (prev2[n - 2] != next[n - 2] && prev2[n - 1] != next[n - 1]) {
			min = Math.min(min, cnt2 + 1);
			signal = true;
		}

		if (signal)
			System.out.println(min);
		else
			System.out.println(-1);
	}
}