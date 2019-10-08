package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b15650 {
	
	public static int n,m;
	public static int [] arr;
	public static boolean [] visit;
	public static StringBuilder ans = new StringBuilder();
	
	public static void go(int idx, int start)
	{
		if(idx == m)
		{
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<m ;i++)
			{
				sb.append(arr[i]);
				if(i!=m-1)
					sb.append(" ");
			}
			sb.append("\n");
			ans.append(sb.toString());
			return;
		}
		if(start>n)
		{
			return;
		}
		for(int i=start; i<=n ;i++)
		{
			if(visit[i])
				continue;
			else
			{
				arr[idx] = i;
				visit[i] = true;
				go(idx+1, i+1);
				arr[idx] = 0;
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int [m];
		visit = new boolean[n+1];
		go(0,1);
		bw.write(ans.toString());
		bw.close();
		br.close();
	}
}
