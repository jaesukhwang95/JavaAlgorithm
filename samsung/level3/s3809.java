package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s3809 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int j = 0;
			while (true) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				while (st.hasMoreTokens())
					arr[j++] = Integer.parseInt(st.nextToken());
				if (j == n)
					break;
			}
			int[] numbers = new int[(n > 1) ? n + (n - 1) + (n - 2) + (n - 3) : 1];
			int k = 0;
			for (int i = 0; i < n; i++) {
				numbers[k++] = arr[i];
			}
			for (int i = 0; i < n - 1; i++) {
				numbers[k++] = 10 * arr[i] + arr[i + 1];
			}
			for (int i = 0; i < n - 2; i++) {
				numbers[k++] = 100 * arr[i] + 10 * arr[i + 1] + arr[i + 2];
			}
			for (int i = 0; i < n - 3; i++) {
				numbers[k++] = 1000 * arr[i] + 100 * arr[i + 1] + 10 * arr[i + 2] + arr[i + 3];
			}
			Arrays.sort(numbers);
			int ans = 0;
			if (numbers[0] != 0)
				ans = 0;
			else {
				int l = 0;
				while (l < 4 * n - 5 && numbers[l] == numbers[l + 1] || numbers[l] + 1 == numbers[l + 1])
					l++;
				ans = numbers[l];
				ans++;
			}
			sb.append("#").append(num + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
