package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b2178 {
	private static class Pair {
		private int x;
		private int y;
		Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	private static int dx [] = {0,0,1,-1};
	private static int dy [] = {1,-1,0,0};
	private static int n, m;
	private static int[][] arr;
	private static int[][] dist;
	private static boolean[][] visit;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];
		dist = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		for(int i=1; i<=n ; i++)
		{
			String str = br.readLine();
			for(int j=1; j<=m; j++)
				arr[i][j] = str.charAt(j-1)-'0';
		}
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(1,1));
		dist[1][1] = 1;
		visit[1][1] = true;
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
					if(!visit[nx][ny] && arr[nx][ny]==1)
					{
						q.offer(new Pair(nx, ny));
						visit[nx][ny] = true;
						dist[nx][ny] = dist[x][y] + 1;
					}
				}
			}
		}
		System.out.println(dist[n][m]);
		br.close();
	}	
}