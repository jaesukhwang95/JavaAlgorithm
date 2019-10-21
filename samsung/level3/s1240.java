package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s1240 {

	public static int Decrypt(String str) {
		if (str.equals("0001101"))
			return 0;
		else if (str.equals("0011001"))
			return 1;
		else if (str.equals("0010011"))
			return 2;
		else if (str.equals("0111101"))
			return 3;
		else if (str.equals("0100011"))
			return 4;
		else if (str.equals("0110001"))
			return 5;
		else if (str.equals("0101111"))
			return 6;
		else if (str.equals("0111011"))
			return 7;
		else if (str.equals("0110111"))
			return 8;
		else if (str.equals("0001011"))
			return 9;
		else
			return Integer.MAX_VALUE;

	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			Integer.parseInt(st.nextToken());
			String cypher = "";
			while (h-- > 0) {
				String str = br.readLine();
				if (str.contains("1")) {
					cypher = str;
					break;
				}
			}
			while (h-- > 0) {
				br.readLine();
			}
			int lastIdx = cypher.lastIndexOf('1');
			String parsedCypher = cypher.substring(lastIdx - 55, lastIdx + 1);
			int[] arr = new int[8];
			int j = 0;
			for (int i = 0; i < 56; i = i + 7) {
				arr[j++] = Decrypt(parsedCypher.substring(i, i + 7));
			}
			int ans = 0;
			if (((arr[0] + arr[2] + arr[4] + arr[6]) * 3 + arr[1] + arr[3] + arr[5] + arr[7]) % 10 == 0)
				ans = arr[0] + arr[2] + arr[4] + arr[6] + arr[1] + arr[3] + arr[5] + arr[7];
			sb.append("#").append(num + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
