package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s4466 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int [] arr = new int [n];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n ;j++)
			{
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int sum = 0;
			int cnt = 0;
			int last = arr.length;
			while(true)
			{
				sum += arr[last-1];
				last--;
				cnt++;
				if(cnt == k)
				{
					 break;
				}
			}
			sb.append("#").append(i+1).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
}
