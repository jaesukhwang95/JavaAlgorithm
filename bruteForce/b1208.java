package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b1208 {

	public static void makeSum(int[] arr, int idx, int sum, ArrayList<Integer> sumArr) {
		if (idx == arr.length) {
			sumArr.add(sum);
			return;
		}
		makeSum(arr, idx + 1, sum + arr[idx], sumArr);
		makeSum(arr, idx + 1, sum, sumArr);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr1 = new int[n / 2];
		int[] arr2 = new int[n - n / 2];
		for (int i = 0; i < n / 2; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		int j = 0;
		for (int i = n / 2; i < n; i++) {
			arr2[j++] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> sum1 = new ArrayList<Integer>();
		ArrayList<Integer> sum2 = new ArrayList<Integer>();

		makeSum(arr1, 0, 0, sum1);
		makeSum(arr2, 0, 0, sum2);

		Collections.sort(sum1);
		Collections.sort(sum2);

		int front = 0;
		int end = sum2.size() - 1;
		long cnt = 0;
		while (front < sum1.size() && end >= 0) {
			int frontDigit = sum1.get(front);
			int endDigit = sum2.get(end);
			int sum = sum1.get(front) + sum2.get(end);
			if (sum > s) {
				end--;
				continue;
			}
			if (sum < s) {
				front++;
				continue;
			}
			if (sum == s) {
				int frontCnt = 0;
				int endCnt = 0;
				while (front < sum1.size() && frontDigit == sum1.get(front)) {
					front++;
					frontCnt++;
				}
				while (end >= 0 && sum2.get(end) == endDigit) {
					end--;
					endCnt++;
				}
				cnt = cnt + (long)frontCnt * endCnt;
				continue;
			}
		}
		if (s == 0)
			System.out.println(cnt - 1);
		else
			System.out.println(cnt);
	}
}
