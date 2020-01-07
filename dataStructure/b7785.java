package baekjoon.dataStructure;

import java.util.*;
import java.io.*;

public class b7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			if (status.equals("enter"))
				set.add(name);
			else
				set.remove(name);
		}
		String[] arr = new String[set.size()];
		int k = 0;
		for (String s : set) {
			arr[k++] = s;
		}
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}
}
