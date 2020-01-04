package baekjoon.dataStructure;

import java.util.*;
import java.io.*;

public class b9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String explodingStr = br.readLine();

		Stack<Character> s = new Stack<Character>();
		for (int i = str.length() - 1; i >= 0; i--) {
			s.push(str.charAt(i));
			if (s.size() >= explodingStr.length() && s.peek() == explodingStr.charAt(0)) {
				boolean signal = true;
				for (int j = 0; j < explodingStr.length(); j++) {
					if (explodingStr.charAt(j) != s.get(s.size() - j - 1)) {
						signal = false;
						break;
					}
				}
				if (signal) {
					for (int j = 0; j < explodingStr.length(); j++)
						s.pop();
				}
			}
		}
		if (s.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			while (!s.isEmpty())
				sb.append(s.pop());
			System.out.println(sb.toString());
		}
	}
}
