package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b2667 {
	
	private static final int[] dx = {1,-1,0,0};
	private static final int[] dy = {0,0,1,-1};
	private static int n;
	private static int[][] arr;
	private static int[][] group;
	private static int[] res;
	private static int cnt;
	
	public static void dfs(int i, int j)
	{
		if(group[i][j] != 0)
			return;
		group[i][j] = cnt;
		for(int k=0; k<4; k++)
		{
			int x = i + dx[k];
			int y = j + dy[k];
			if(1<=x && x<=n && 1<=y && y<=n && group[x][y]==0 && arr[x][y]==1)
			{
				dfs(x, y);
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		group = new int[n+1][n+1];
		cnt = 0;
		for(int i=1; i<=n ; i++)
		{
			String str = br.readLine();
			for(int j=1; j<=n ; j++)
			{
				arr[i][j] = str.charAt(j-1)-'0';
			}
		}
		for(int i=1; i<=n ; i++)
		{
			for(int j=1; j<=n ; j++)
			{
				if(group[i][j]==0 && arr[i][j]==1)
				{
					cnt++;
					dfs(i, j);
				}
			}
		}
		res = new int[cnt];
		for(int i=1; i<=n ; i++)
		{
			for(int j=1; j<=n ; j++)
			{
				if(group[i][j] != 0)
				res[group[i][j]-1]++;
			}
		}
		Arrays.sort(res);
		sb.append(cnt+"\n");
		for(int i=0; i<cnt; i++)
		{
			sb.append(res[i]+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}