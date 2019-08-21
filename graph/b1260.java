package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b1260 {
	
	private static int[][] arr;
	private static boolean[] visit;
	private static int n;
	private static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int x)
	{
		if(visit[x])
			return;
		visit[x] = true;
		sb.append(x).append(" ");
		for(int i=1; i<=n ; i++)
		{
			if(arr[x][i] == 1)
				dfs(i);
		}
	}
	
	public static void bfs(int x)
	{
		if(visit[x])
			return;
		visit[x] = true;
		sb.append(x).append(" ");
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		while(!q.isEmpty())
		{
			int p = q.poll();
			for(int i=1; i<=n ; i++)
			{
				if(arr[p][i]==1 && !visit[i])
				{
					visit[i] = true;
					sb.append(i).append(" ");
					q.offer(i);
				}
			}
		}
	}
	
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<m ;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		dfs(start);
		sb.append("\n");
		visit = new boolean[n+1];
		bfs(start);
		sb.append("\n");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}