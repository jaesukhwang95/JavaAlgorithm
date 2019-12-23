package baekjoon.greedy;

import java.io.*;

public class b12919 {

	public static boolean signal = false;

	public static String reverseString(String input) {
		char[] arr = input.toCharArray();
		for (int i = 0; i < arr.length / 2; i++) {
			arr[input.length() - i - 1] = input.charAt(i);
			arr[i] = input.charAt(input.length() - i - 1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++)
			sb.append(arr[i]);
		return sb.toString();
	}

	public static void checkSame(String start, String end) {
		if (start.equals(end)) {
			signal = true;
			return;
		}
		if (start.length() == end.length())
			return;
		char front = start.charAt(0);
		char rear = start.charAt(start.length() - 1);
		if (front == 'A' && rear == 'B') {
			return;
		} else if (front == 'B' && rear == 'A') {
			checkSame(start.substring(0, start.length() - 1), end);
			String s = reverseString(start);
			checkSame(s.substring(0, start.length() - 1), end);
		} else if (front == 'B' && rear == 'B') {
			String s = reverseString(start);
			checkSame(s.substring(0, start.length() - 1), end);
		} else if (front == 'A' && rear == 'A') {
			checkSame(start.substring(0, start.length() - 1), end);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String end = br.readLine();
		String start = br.readLine();
		checkSame(start, end);
		if (signal)
			System.out.println(1);
		else
			System.out.println(0);
	}
}
