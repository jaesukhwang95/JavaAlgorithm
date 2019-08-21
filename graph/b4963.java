package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b4963 {
	
	private static int[] dx = {0,0,1,1,1,-1,-1,-1};
	private static int[] dy = {1,-1,-1,0,1,-1,0,1};
	private static int[][] group;
	private static int[][] arr;
	private static int cnt, n, m;
	
	public static void dfs(int a, int b)
	{
		if(group[a][b]!=0)
			return;
		group[a][b] = cnt;
		for(int i=0; i<8 ;i++)
			for(int j=0; j<8 ;j++)
			{
				int x = dx[i] + a;
				int y = dy[j] + b;
				if(1<=x && x<=n && 1<=y && y<=m && arr[x][y]==1)
				{
					dfs(x, y);
				}
			}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			cnt=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			arr = new int[n+1][m+1];
			group = new int[n+1][m+1];
			for(int i=1; i<=n ; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=m; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=1; i<=n ; i++)
				for(int j=1; j<=m; j++)
				{
					if(group[i][j] == 0 && arr[i][j] == 1)
					{
						cnt++;
						dfs(i, j);
					}
				}
			sb.append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}