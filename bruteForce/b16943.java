package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b16943 {

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static boolean beforePermutation(int[] a) {
		int i = a.length - 1;
		while (i > 0 && a[i - 1] <= a[i]) {
			i -= 1;
		}
		if (i <= 0) {
			return false;
		}
		int j = a.length - 1;
		while (a[j] >= a[i - 1]) {
			j -= 1;
		}
		swap(a, i - 1, j);
		j = a.length - 1;
		while (i < j) {
			swap(a, i, j);
			i += 1;
			j -= 1;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		int target = Integer.parseInt(st.nextToken());
		int[] start = new int[input.length()];
		for (int i = 0; i < start.length; i++) {
			start[i] = input.charAt(i) - '0';
		}
		Arrays.sort(start);
		for(int i=0; i<start.length/2 ;i++)
		{
			int temp = start[i];
			start[i] = start[start.length-1-i];
			start[start.length-1-i] = temp;
		}
		int[] temp = new int[input.length()];
		do {
			if (start[0] == 0)
				continue;
			int digit = 0;
			for (int i = 0; i < start.length; i++) {
				digit = digit * 10 + start[i];
			}
			if (digit <= target) {
				for (int i = 0; i < start.length; i++)
					temp[i] = start[i];
				break;
			}
		} while (beforePermutation(start));
		int ans = 0;
		for (int i = 0; i < temp.length; i++) {
			ans = ans * 10 + temp[i];
		}
		if(ans == 0)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(ans);
		}
	}
}
