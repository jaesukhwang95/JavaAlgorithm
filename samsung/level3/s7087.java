package baekjoon.samsung.level3;

import java.util.*;
import java.io.*;

public class s7087 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			int cnt = Integer.parseInt(br.readLine());
			String[] words = new String[cnt];
			for (int i = 0; i < cnt; i++) {
				words[i] = br.readLine();
			}
			Arrays.sort(words);
			int indexCount = 0;
			if (words[0].charAt(0) != 'A')
				indexCount = 0;
			else {
				indexCount = 1;
				for (int i = 1; i < cnt; i++) {
					if (words[i].charAt(0) == words[i - 1].charAt(0))
						continue;
					else if (words[i].charAt(0) - '0' == words[i - 1].charAt(0) - '0' + 1)
						indexCount++;
					else
						break;
				}
			}
			sb.append("#").append(num + 1).append(" ").append(indexCount).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
