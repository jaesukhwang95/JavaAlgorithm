package baekjoon.graph;
import java.io.*;
import java.util.*;

public class b2146 {
	private static class Pair
	{
		private int x;
		private int y;
		Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][n+1];
		int[][] group = new int[n+1][n+1];
		int[][] dist = new int[n+1][n+1];
		for(int i=1; i<=n ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		Queue<Pair> q = new LinkedList<Pair>();
		int cnt = 1;
		for(int i=1; i<=n ;i++)
			for(int j=1; j<=n; j++)
			{
				if(arr[i][j]==1 && group[i][j]==0)
				{
					q.offer(new Pair(i,j));
					while(!q.isEmpty())
					{
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						if(group[x][y] == 0)
						{
							group[x][y] = cnt++;
						}
						for(int k=0; k<4 ;k++)
						{
							int nx = x + dx[k];
							int ny = y + dy[k];
							if(1<=nx && nx<=n && 1<=ny && ny<=n)
							{
								if(group[nx][ny]==0 && arr[nx][ny]==1)
								{
									group[nx][ny] = group[x][y];
									q.offer(new Pair(nx, ny));
								}
							}
						}
					}
				}
			}
		q = new LinkedList<Pair>();
		for(int i=1; i<=n; i++)
			for(int j=1; j<=n; j++)
			{
				dist[i][j] = -1;
				if(arr[i][j]==1)
				{
					dist[i][j] = 0;
					q.offer(new Pair(i, j));
				}
			}
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++)
			{
				int nx = x+ dx[k];
				int ny = y+ dy[k];
				if(1<=nx && nx<=n && 1<=ny && ny<=n)
				{
					if(dist[nx][ny] == -1)
					{
						group[nx][ny] = group[x][y];
						dist[nx][ny] = dist[x][y] +1;
						q.offer(new Pair(nx, ny));
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=n ;i++)
			for(int j=1; j<=n ;j++)
			{
				int x = i;
				int y = j;
				for(int k=0; k<4; k++)
				{
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(1<=nx && nx<=n && 1<=ny && ny<=n)
					{
						if(group[x][y] != group[nx][ny] && min > dist[x][y]+dist[nx][ny])
						{
							min = dist[x][y]+dist[nx][ny];
						}
					}
				}
			}
		System.out.println(min);
		br.close();
	}
}
