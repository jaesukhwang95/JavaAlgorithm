package baekjoon.graph;
import java.io.*;
import java.util.*;

public class b9466 {
	private static int arr[];
	private static int visit[];
	private static int level[];
	
	public static int dfs(int x, int cnt, int step)
	{
		if(visit[x]!=0)
		{
			if(level[x] != step)
				return 0;
			else
				return cnt-visit[x];
		}
		visit[x] = cnt;
		level[x] = step;
		return dfs(arr[x], cnt+1, step);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int ans = 0;
			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			visit = new int[n+1];
			level = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n ;i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1; i<=n ;i++)
			{
				ans =  ans + dfs(i, 1, i);
			}
			ans = n - ans;
			System.out.println(ans);
		}
		br.close();
	}
}