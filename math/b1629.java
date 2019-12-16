package baekjoon.math;

import java.util.*;
import java.io.*;

public class b1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int mod = Integer.parseInt(st.nextToken());
		long ans = 1;
		long operand = A % mod;
		while (B > 0) {
			if (B % 2 == 1) {
				ans = ans * operand;
				ans = ans % mod;
			}
			operand = (operand % mod) * (operand % mod) % mod;
			B /= 2;
		}
		System.out.println(ans);
	}
}
