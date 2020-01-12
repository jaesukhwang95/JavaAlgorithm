package baekjoon.bruteForce;

import java.io.*;

public class b9095 {

	public static int method = 0;

	public static void findMethod(int num) {
		if (num < 0)
			return;
		if (num == 0) {
			method++;
			return;
		}
		for (int i = 1; i <= 3; i++) {
			num = num - i;
			findMethod(num);
			num = num + i;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		for (int i = 0; i < total; i++) {
			int num = Integer.parseInt(br.readLine());
			findMethod(num);
			sb.append(method + "\n");
			method = 0;
		}
		System.out.print(sb.toString());
	}
}
