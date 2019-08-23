package baekjoon.graph;
import java.io.*;
import java.util.*;

public class b2206 {
	public static class Pair{
		private int x;
		private int y;
		private int z;
		Pair(int x, int y, int z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [][] arr = new int[n+1][m+1];
		int [][][] dist = new int[n+1][m+1][2];
		int [] dx = {-1,1,0,0};
		int [] dy = {0,0,-1,1};
		for(int i=1; i<=n ;i++)
		{
			String str = br.readLine();
			for(int j=1; j<=m; j++)
			{
				arr[i][j] = str.charAt(j-1)-'0';
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(1,1,0));
		dist[1][1][0] = 1;
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			int z = p.z;
			for(int i=0; i<4; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z;
				if(1<=nx && nx<=n && 1<=ny && ny<=m)
				{
					if(dist[nx][ny][nz]==0 && arr[nx][ny]==0)
					{
						dist[nx][ny][nz] = dist[x][y][z]+1;
						q.offer(new Pair(nx, ny, nz));
					}
					if(nz==0 && dist[nx][ny][nz+1]==0 && arr[nx][ny]==1)
					{
						dist[nx][ny][nz+1] = dist[x][y][z]+1;
						q.offer(new Pair(nx, ny, nz+1));
					}
				}
			}
		}
		if(dist[n][m][0]!=0 && dist[n][m][1]!=0)
			System.out.println(Math.min(dist[n][m][0], dist[n][m][1]));
		else if(dist[n][m][0]!=0)
			System.out.println(dist[n][m][0]);
		else if(dist[n][m][1]!=0)
			System.out.println(dist[n][m][1]);
		else
			System.out.println(-1);		
	}
}