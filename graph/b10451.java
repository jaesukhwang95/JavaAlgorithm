package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b10451 {
	
	private static int[] arr;
	private static boolean[] visit;
	private static int n;
	
	public static void dfs(int k)
	{
		visit[k] = true;
		if(!visit[arr[k]])
			dfs(arr[k]);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			n = Integer.parseInt(br.readLine());
			int cnt = 0;
			arr = new int[n+1];
			visit = new boolean[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1; i<=n; i++)
			{
				if(!visit[i])
				{
					dfs(i);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}