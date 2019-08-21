package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b1707 {
	
	private static ArrayList<Integer>[] arr;
	private static int[] visit;
	private static int n;
	
	public static void dfs(int x, int check)
	{
		visit[x] = check;
		for(int i: arr[x])
		{
			if(visit[i] == 0)
				dfs(i, 3-check);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new ArrayList[n+1];
			visit = new int[n+1];
			for(int i=1; i<=n ; i++)
			{
				arr[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<m ; i++)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				arr[b].add(a);
			}
			for(int i=1; i<=n ; i++)
			{
				if(visit[i] == 0)
					dfs(i, 1);
			}
			boolean signal = true;
			for(int i=1; i<=n; i++)
			{
				for(int j: arr[i])
				{	
					if(visit[i] == visit[j])
					{
						signal = false;
						break;
					}
					
				}
				if(!signal)
					break;
			}
			if(signal)
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}