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
				}
				else if(arr[i][j] == 'S')
				{
					ssx = i;
					ssy = j;
				}
				else if(arr[i][j] == 'D')
				{
					dsx = i;
					dsy = j;
				}
			}
		}
		arr[dsx][dsy] = '.';
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
					if(arr[nx][ny] == '.' && water[nx][ny]==0 && arr[nx][ny] != 'X' && arr[nx][ny] != 'S')
					{
						q.offer(new Pair(nx, ny));
						water[nx][ny] = water[x][y] + 1;
					}
				}
			}
		}
		for(int i=1; i<=n ;i++)
		{
			for(int j=1; j<=m; j++)
			{
				System.out.print(water[i][j]+" ");
			}
			System.out.println();
		}
	}
}
