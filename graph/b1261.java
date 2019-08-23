package baekjoon.graph;
import java.io.*;
import java.util.*;

public class b1261 {
	
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
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int [][] arr = new int[n+1][m+1];
		int [][] dist = new int[n+1][m+1];
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		for(int i=1; i<=n; i++)
		{
			String str = br.readLine();
			for(int j=1; j<=m; j++)
			{
				arr[i][j] = str.charAt(j-1)-'0';
				dist[i][j] = -1;
			}
		}
		dist[1][1] = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		Queue<Pair> qNext = new LinkedList<Pair>();
		q.offer(new Pair(1,1));
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4 ;i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(1<=nx && nx<=n && 1<=ny && ny<=m)
				{
					if(dist[nx][ny] == -1 && arr[nx][ny] == 0)
					{
						q.offer(new Pair(nx,ny));
						dist[nx][ny] = dist[x][y];
					}
					if(dist[nx][ny] == -1 && arr[nx][ny] == 1)
					{
						qNext.offer(new Pair(nx,ny));
						dist[nx][ny] = dist[x][y] + 1;
					}
				}
			}
			if(q.isEmpty())
			{
				q = qNext;
				qNext = new LinkedList<Pair>();
			}
		}
		System.out.println(dist[n][m]);
		br.close();
	}
}