package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s8673 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			int k = Integer.parseInt(br.readLine());
			int sum = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i< Math.pow(2,k) ;i++)
			{
				q.offer(Integer.parseInt(st.nextToken()));
			}
			while(true)
			{
				int first =q.poll();
				if(q.isEmpty())
					break;
				int second =q.poll();
				if(first < second)
				{
					int temp = 0;
					temp = first;
					first = second;
					second = temp;
				}
				sum = sum + first - second;
				q.offer(first);
			}
			sb.append("#").append(num + 1).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
