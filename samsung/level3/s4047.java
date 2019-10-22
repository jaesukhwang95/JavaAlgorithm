package baekjoon.samsung.level3;

import java.io.*;

public class s4047 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			boolean[] s = new boolean[14];
			boolean[] d = new boolean[14];
			boolean[] h = new boolean[14];
			boolean[] c = new boolean[14];
			String str = br.readLine();
			boolean signal = false;
			for (int i = 0; i < str.length(); i = i + 3) {
				String info = (str.substring(i, i + 3));
				if (info.charAt(0) == 'S') {
					int idx = Integer.valueOf(info.substring(1, 3));
					if (!s[idx])
						s[idx] = true;
					else {
						signal = true;
						break;
					}
				} else if (info.charAt(0) == 'D') {
					int idx = Integer.valueOf(info.substring(1, 3));
					if (!d[idx])
						d[idx] = true;
					else {
						signal = true;
						break;
					}
				} else if (info.charAt(0) == 'H') {
					int idx = Integer.valueOf(info.substring(1, 3));
					if (!h[idx])
						h[idx] = true;
					else {
						signal = true;
						break;
					}
				} else if (info.charAt(0) == 'C') {
					int idx = Integer.valueOf(info.substring(1, 3));
					if (!c[idx])
						c[idx] = true;
					else {
						signal = true;
						break;
					}
				}
			}
			int[] cnt = { 13, 13, 13, 13 };
			for (int j = 1; j < 14; j++) {
				if (s[j])
					cnt[0]--;
				if (d[j])
					cnt[1]--;
				if (h[j])
					cnt[2]--;
				if (c[j])
					cnt[3]--;
			}
			if (signal)
				sb.append("#").append(num + 1).append(" ").append("ERROR").append("\n");
			else
				sb.append("#").append(num + 1).append(" ").append(cnt[0]).append(" ").append(cnt[1]).append(" ")
						.append(cnt[2]).append(" ").append(cnt[3]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
