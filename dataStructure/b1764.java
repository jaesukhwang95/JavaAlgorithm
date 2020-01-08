package baekjoon.dataStructure;

import java.util.*;
import java.io.*;

public class b1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int noListenNumber = Integer.parseInt(st.nextToken());
		int noSeeNumber = Integer.parseInt(st.nextToken());
		HashSet<String> NoListen = new HashSet<String>();
		HashSet<String> NoSee = new HashSet<String>();
		ArrayList<String> ans = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < noListenNumber; i++) {
			NoListen.add(br.readLine());
		}
		for (int i = 0; i < noSeeNumber; i++) {
			NoSee.add(br.readLine());
		}
		for (String s : NoListen) {
			if (NoSee.contains(s)) {
				ans.add(s);
			}
		}
		Collections.sort(ans);
		sb.append(ans.size() + "\n");
		for (String s : ans) {
			sb.append(s + "\n");
		}
		System.out.print(sb.toString());
	}
}
