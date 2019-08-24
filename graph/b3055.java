package baekjoon.graph;
import java.io.*;
import java.util.*;

public class b3055 {
	
	public static class Pair
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n+1][m+1];
		int[][] water = new int[n+1][m+1];
		int[][] dist = new int[n+1][m+1];
		int ssx=0, ssy=0, dsx=0, dsy=0;
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		for(int i=1; i<=n ;i++)
		{
			String str = br.readLine();
			for(int j=1; j<=m; j++)
				arr[i][j] = str.charAt(j-1);
		}
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i=1; i<=n ;i++)
		{
			for(int j=1; j<=m; j++)
			{
				if(arr[i][j] == '*')
				{
					q.offer(new Pair(i,j));
					water[i][j] = 1;
					arr[i][j] = '.';
				}
				else if(arr[i][j] == 'S')
				{
					ssx = i;
					ssy = j;
					arr[i][j] = '.';
				}
				else if(arr[i][j] == 'D')
				{
					dsx = i;
					dsy = j;
				}
			}
		}
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++)
			{
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(1<=nx && nx<=n && 1<=ny && ny<=m)
				{
					if(arr[nx][ny] == '.' && water[nx][ny]==0 && arr[nx][ny] != 'X' && arr[nx][ny] != 'D')
					{
						q.offer(new Pair(nx, ny));
						water[nx][ny] = water[x][y] + 1;
					}
				}
			}
		}
		q = new LinkedList<Pair>();
		q.offer(new Pair(ssx, ssy));
		dist[ssx][ssy] = 1;
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++)
			{
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(1<=nx && nx<=n && 1<=ny && ny<=m)
				{
					if((arr[nx][ny] == '.' && arr[nx][ny] != 'X' && dist[nx][ny]==0) || (arr[nx][ny] == 'D' && dist[nx][ny]==0))
					{
						if((dist[x][y]+1 < water[nx][ny]) || (water[nx][ny]==0))
						{
							q.offer(new Pair(nx, ny));
							dist[nx][ny] = dist[x][y] + 1;
						}
					}
				}
			}
		}
		if(dist[dsx][dsy]-1 == -1)
		{
			System.out.println("KAKTUS");
		}
		else
		{
			System.out.println(dist[dsx][dsy]-1);
		}
	}
}