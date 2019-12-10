package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s8931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int ans = 0;
			int num = Integer.parseInt(br.readLine());
			Stack<Integer> s = new Stack<Integer>();
			for (int j = 0; j < num; j++) {
				int in = Integer.parseInt(br.readLine());
				if (in != 0) {
					s.push(in);
				} else {
					s.pop();
				}
			}
			for (int element : s) {
				ans = ans + element;
			}
			sb.append("#").append(i + 1).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
