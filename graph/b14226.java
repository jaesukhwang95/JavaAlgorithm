package baekjoon.graph;
import java.io.*;
import java.util.*;

public class b14226 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int[][] dist = new int[a+1][a+1];
		for(int i=0; i<=a; i++)
			for(int j=0; j<=a; j++)
				dist[i][j] = -1;
		dist[1][0] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(0);
		while(!q.isEmpty())
		{
			int s = q.poll();
			int c = q.poll();
			if(s<=a)
			{
				if(dist[s][s] == -1)
				{
					q.offer(s);
					q.offer(s);
					dist[s][s] = dist[s][c]+1;
				}
			}
			if(s+c<=a)
			{
				if(dist[s+c][c] == -1)
				{
					q.offer(s+c);
					q.offer(c);
					dist[s+c][c] = dist[s][c]+1;
				}
			}
			if(s-1>=0)
			{
				if(dist[s-1][c] == -1)
				{
					q.offer(s-1);
					q.offer(c);
					dist[s-1][c] = dist[s][c]+1;
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<=a ;i++)
		{
			if(dist[a][i] < ans)
			{
				if(dist[a][i] != -1)
					ans = dist[a][i];
			}
		}
		System.out.println(ans);
	}
}