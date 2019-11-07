package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class b1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] digitArr = str.split("\\+|-");
		Queue<Integer> digit = new LinkedList<Integer>();
		Queue<Character> op = new LinkedList<Character>();

		for (int i = 0; i < digitArr.length; i++) {
			digit.add(Integer.parseInt(digitArr[i]));
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-')
				op.add(str.charAt(i));
		}
		int sum = digit.poll();
		int idx = 0;
		while (!op.isEmpty()) {
			char operation = op.poll();
			if (operation == '+' && idx == 0) {
				sum = sum + digit.poll();
				while (!op.isEmpty() && op.peek() == '+') {
					op.poll();
					sum = sum + digit.poll();
				}
				idx++;
			} else {
				{
					sum = sum - digit.poll();
					idx++;
				}
			}
		}
		System.out.println(sum);
	}
}
