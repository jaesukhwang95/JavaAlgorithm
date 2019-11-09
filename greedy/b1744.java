package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class b1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int minus = 0;
		int zero = 0;
		int plus = 0;
		int one = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] == 1)
				one++;
			else if (arr[i] < 0)
				minus++;
			else if (arr[i] == 0)
				zero++;
			else
				plus++;
		}

		Arrays.sort(arr);
		if (minus % 2 == 0 && minus != 0) {
			for (int i = 0; i < minus - 1; i = i + 2) {
				sum += arr[i] * arr[i + 1];
			}
			if (one != 0) {
				sum += one;
			}
			if (plus % 2 == 0) {
				for (int i = 0; i < plus - 1; i = i + 2) {
					sum += arr[arr.length - 1 - i] * arr[arr.length - 1 - (i + 1)];
				}
			} else {
				for (int i = 0; i < plus - 2; i = i + 2) {
					sum += arr[arr.length - 1 - i] * arr[arr.length - 1 - (i + 1)];
				}
				sum += arr[arr.length - 1 - (plus - 1)];
			}

		} else {
			for (int i = 0; i < minus - 2; i = i + 2) {
				sum += arr[i] * arr[i + 1];
			}
			if (zero == 0 && minus != 0) {
				sum += arr[minus - 1];
			}
			if (one != 0) {
				sum += one;
			}
			if (plus % 2 == 0) {
				for (int i = 0; i < plus - 1; i = i + 2) {
					sum += arr[arr.length - 1 - i] * arr[arr.length - 1 - (i + 1)];
				}
			} else {
				for (int i = 0; i < plus - 2; i = i + 2) {
					sum += arr[arr.length - 1 - i] * arr[arr.length - 1 - (i + 1)];
				}
				sum += arr[arr.length - 1 - (plus - 1)];
			}
		}
		System.out.println(sum);

	}
}
