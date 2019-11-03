package baekjoon.bruteForce;

import java.io.*;

public class b16968 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int ans = 1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'c') {
				ans *= 26;
				while (i < str.length() - 1 && str.charAt(i + 1) == 'c') {
					ans *= 25;
					i++;
				}
			} else {
				ans *= 10;
				while (i < str.length() - 1 && str.charAt(i + 1) == 'd') {
					ans *= 9;
					i++;
				}
			}
		}
		System.out.println(ans);
	}
}
