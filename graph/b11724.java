package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b11724 {
	
	private static int[][] arr;
	private static boolean[] visit;
	private static int n;
	
	public static void dfs(int start)
	{
		if(visit[start])
			return;
		visit[start] = true;
		for(int i=1; i<=n; i++)
		{
			if(arr[i][start] == 1)
				dfs(i);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int [n+1][n+1];
		visit = new boolean[n+1];
		for(int i=0; i<m ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		for(int i=1; i<=n ;i++)
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