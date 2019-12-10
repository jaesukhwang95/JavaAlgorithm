package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s1221 {

	public static int checkDigit(String str) {
		if (str.equals("ZRO"))
			return 0;
		else if (str.equals("ONE"))
			return 1;
		else if (str.equals("TWO"))
			return 2;
		else if (str.equals("THR"))
			return 3;
		else if (str.equals("FOR"))
			return 4;
		else if (str.equals("FIV"))
			return 5;
		else if (str.equals("SIX"))
			return 6;
		else if (str.equals("SVN"))
			return 7;
		else if (str.equals("EGT"))
			return 8;
		else if (str.equals("NIN"))
			return 9;
		return -1;
	}

	public static String digitToString(int num) {
		if (num == 0)
			return "ZRO";
		else if (num == 1)
			return "ONE";
		else if (num == 2)
			return "TWO";
		else if (num == 3)
			return "THR";
		else if (num == 4)
			return "FOR";
		else if (num == 5)
			return "FIV";
		else if (num == 6)
			return "SIX";
		else if (num == 7)
			return "SVN";
		else if (num == 8)
			return "EGT";
		else if (num == 9)
			return "NIN";
		return "";

	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			int[] digit = new int[10];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				String str = st.nextToken();
				int num = checkDigit(str);
				digit[num]++;
			}
			StringBuilder ans = new StringBuilder();
			for (int j = 0; j < 10; j++) {
				while (digit[j]-- > 0) {
					ans.append(digitToString(j)).append(" ");
				}
			}
			sb.append("#").append(i + 1).append("\n").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}