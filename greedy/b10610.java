package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class b10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sum = 0;
		int[] arr = new int[str.length()];
		boolean signal = false;
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - '0';
			sum += arr[i];
			if (arr[i] == 0)
				signal = true;
		}
		if (sum % 3 != 0 || !signal) {
			System.out.println(-1);
		} else {
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			for (int i = arr.length - 1; i >= 0; i--) {
				sb.append(arr[i]);
			}
			System.out.println(sb.toString());
		}
	}
}
