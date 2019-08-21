package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b7576 {
	private static class Pair{
		private int x;
		private int y;
		Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};	
	private static int[][] arr;
	private static int[][] dist;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];
		dist = new int[n+1][m+1];
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i=1; i<=n ;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m ;j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = -1;
				if(arr[i][j] == 1) {
					q.offer(new Pair(i, j));
					dist[i][j] = 0;
				}	
			}
		}
		int max = Integer.MIN_VALUE;
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4 ; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(1<=nx && nx<=n && 1<=ny && ny<=m)
				{
					if(arr[nx][ny]==0 && dist[nx][ny]==-1)
					{
						q.offer(new Pair(nx, ny));
						dist[nx][ny] = dist[x][y] + 1;
					}
				}
			}
		}
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				max = Math.max(max, dist[i][j]);
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
					if(dist[i][j] == -1 && arr[i][j] == 0)
					{
						max = -1;
						break;
					}
		System.out.println(max);
		br.close();
	}
}