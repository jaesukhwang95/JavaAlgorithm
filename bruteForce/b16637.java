package baekjoon.bruteForce;

import java.io.*;

public class b16637 {

	public static int operation(int a, int b, char op) {
		if (op == '+')
			return a + b;
		else if (op == '-')
			return a - b;
		else if (op == '*')
			return a * b;
		else
			return 0;
	}

	public static void go(int idx, int res) {
		if (idx >= operationNumber) {
			ans = Math.max(ans, res);
			return;
		}
		int res1 = operation(res, num[idx + 1], op[idx]);
		go(idx + 1, res1);
		if (idx < operationNumber - 1) {
			int nRes = operation(num[idx + 1], num[idx + 2], op[idx + 1]);
			int res2 = operation(res, nRes, op[idx]);
			go(idx + 2, res2);
		}

	}

	public static int ans = Integer.MIN_VALUE;
	public static int operationNumber;
	public static int digitNumber;
	public static char[] op;
	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		operationNumber = n / 2;
		digitNumber = n - operationNumber;
		op = new char[operationNumber];
		num = new int[digitNumber];
		int k1 = 0;
		int k2 = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 0) {
				num[k1++] = str.charAt(i) - '0';
			} else {
				op[k2++] = str.charAt(i);
			}
		}
		go(0, num[0]);
		System.out.println(ans);
	}
}
