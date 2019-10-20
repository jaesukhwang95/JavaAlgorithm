package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s7272 {

	public static int AlphabetFlag(char alphabet) {
		if (alphabet == 'C' || alphabet == 'E' || alphabet == 'F' || alphabet == 'G' || alphabet == 'H'
				|| alphabet == 'I' || alphabet == 'J' || alphabet == 'K' || alphabet == 'L' || alphabet == 'M'
				|| alphabet == 'N' || alphabet == 'S' || alphabet == 'T' || alphabet == 'U' || alphabet == 'V'
				|| alphabet == 'W' || alphabet == 'X' || alphabet == 'Y' || alphabet == 'Z')
			return 0;
		else if (alphabet == 'A' || alphabet == 'D' || alphabet == 'O' || alphabet == 'P' || alphabet == 'Q'
				|| alphabet == 'R')
			return 1;
		else if (alphabet == 'B')
			return 2;
		else
			return 3;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String ans = "";
			String first = st.nextToken();
			String second = st.nextToken();
			boolean diffSignal = false;
			if (first.length() != second.length()) {
				ans = "DIFF";
			} else {
				for (int j = 0; j < first.length(); j++) {
					if (AlphabetFlag(first.charAt(j)) != AlphabetFlag(second.charAt(j))) {
						diffSignal = true;
						break;
					}
				}
				if (diffSignal)
					ans = "DIFF";
				else
					ans = "SAME";
			}
			sb.append("#").append(i + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
