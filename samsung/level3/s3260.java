package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s3260 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringBuilder ans = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			String first = st.nextToken();
			String second = st.nextToken();
			String big;
			String small;

			if (first.length() >= second.length()) {
				big = first;
				small = second;
			} else {
				big = second;
				small = first;
			}
			int carry = 0;
			int num1 = 0;
			int num2 = 0;
			int total = 0;
			int diff = big.length() - small.length();
			for (int j = big.length(); j >= 0; j--) {
				if (j == 0) {
					num1 = 0;
				} else {
					num1 = (int) (big.charAt(j - 1) - '0');
				}
				if (j < diff + 1) {
					num2 = 0;
				} else {
					num2 = (int) (small.charAt(j - diff - 1) - '0');
				}
				total = num1 + num2 + carry;
				if (total >= 10) {
					carry = 1;
					total -= 10;
				} else {
					carry = 0;
				}
				ans.insert(0, total);
			}
			String result = ans.toString();
			if (result.charAt(0) == '0')
				sb.append("#").append(i + 1).append(" ").append(ans.substring(1)).append("\n");
			else
				sb.append("#").append(i + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
