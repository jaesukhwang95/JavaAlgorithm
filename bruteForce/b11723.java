package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] visit = new boolean[21];
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				visit[num] = true;
			} else if (cmd.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				visit[num] = false;
			} else if (cmd.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if (visit[num])
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			} else if (cmd.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if (visit[num])
					visit[num] = false;
				else
					visit[num] = true;
			} else if (cmd.equals("all")) {
				for (int i = 1; i <= 20; i++)
					visit[i] = true;
			} else if (cmd.equals("empty")) {
				for (int i = 1; i <= 20; i++)
					visit[i] = false;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
