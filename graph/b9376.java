package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b9376 {
	
	public static class Pair
	{
		int x; 
		int y;
		Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	public static int [] dx = {-1,1,0,0};
	public static int [] dy = {0,0,-1,1};

			
	public static void bfs(int [][] dist, char[][] jail, Pair person, int h, int w)
	{
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(person);
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4 ;i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= h+2 || ny < 0 || ny >= w+2)
					continue;
				if(jail[nx][ny] == '*')
					continue;
				if(jail[nx][ny] == '.' || jail[nx][ny] == '$')
				{
					if(dist[nx][ny] == -1 || dist[nx][ny] > dist[x][y]) {
						dist[nx][ny] = dist[x][y];
						q.offer(new Pair(nx, ny));
					}
				}
				else if(jail[nx][ny] == '#')
				{ 
					if(dist[nx][ny] == -1 || dist[nx][ny] > dist[x][y] + 1) {
						dist[nx][ny] = dist[x][y] + 1;
						q.offer(new Pair(nx, ny));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char [][] jail = new char[h+2][w+2];
			
			int [][] dist1 = new int[h+2][w+2];
			int [][] dist2 = new int[h+2][w+2];
			int [][] dist3 = new int[h+2][w+2];

			for(int i=0; i<h+2 ;i++)
			{
				for(int j=0; j<w+2; j++)
				{
					dist1[i][j] = -1;
					dist2[i][j] = -1;
					dist3[i][j] = -1;
				}
			}
			
			Pair person1 = null;
			Pair person2 = null;
			for(int i=0; i<h+2 ;i++)
			{
				for(int j=0; j<w+2; j++)
				{
					jail[i][j] = '.';
				}
			}
			for(int i=1; i<h+1 ;i++)
			{
				String str = br.readLine();
				for(int j=0; j<w; j++)
				{
					jail[i][j+1] = str.charAt(j);
					if(str.charAt(j)=='$' && person1 == null)
					{
						person1 = new Pair(i, j+1);
					}
					if(str.charAt(j)=='$' && person1 != null)
					{
						person2 = new Pair(i, j+1);
					}
				}
			}
			Pair sang = new Pair(0, 0);
			dist1[sang.x][sang.y] = 0;
			bfs(dist1, jail, sang, h, w);
			dist2[person1.x][person1.y] = 0;
			bfs(dist2, jail, person1, h, w);
			dist3[person2.x][person2.y] = 0;
			bfs(dist3, jail, person2, h, w);
			
			for(int i=0; i<h+2 ;i++)
			{
				for(int j=0; j<w+2; j++)
				{
					if(dist1[i][j]+dist2[i][j]+dist3[i][j] < 0)
						continue;
					if(jail[i][j] != '#')
						min = Math.min(min, dist1[i][j]+dist2[i][j]+dist3[i][j]);
					else
						min = Math.min(min, dist1[i][j]+dist2[i][j]+dist3[i][j]-2);
				}
			}
			System.out.println(min);	
		}
	}
}
