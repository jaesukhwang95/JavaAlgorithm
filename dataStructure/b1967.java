package baekjoon.dataStructure;
import java.util.*;
import java.io.*;

public class b1967 {
	
	public static class Info
	{
		int vertex;
		int dist;
		Info(int vertex, int dist)
		{
			this.vertex = vertex;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Info> [] arr = new ArrayList [n+1];
		for(int i=1; i<=n ;i++)
		{
			arr[i] = new ArrayList<Info>();
		}
		for(int i=1; i<n ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Info(b,c));
			arr[b].add(new Info(a,c));
		}
		Queue<Info> q = new LinkedList<Info>();
		boolean [] visit = new boolean[n+1];
		q.offer(new Info(1, 0));
		visit[1] = true;
		int start = 1;
		int maxDist = 0;
		while(!q.isEmpty())
		{
			Info info = q.poll();
			int vertex = info.vertex;
			int dist = info.dist;
			for(Info j: arr[vertex])
			{
				if(!visit[j.vertex])
				{
					visit[j.vertex] = true;
					q.offer(new Info(j.vertex, dist+j.dist));
					if(maxDist < dist+j.dist)
					{
						maxDist = dist + j.dist;
						start = j.vertex;
					}
				}
			}
		}
		visit = new boolean[n+1];
		q.offer(new Info(start, 0));
		visit[start] = true;
		maxDist = 0;
		while(!q.isEmpty())
		{
			Info info = q.poll();
			int vertex = info.vertex;
			int dist = info.dist;
			for(Info j: arr[vertex])
			{
				if(!visit[j.vertex])
				{
					visit[j.vertex] = true;
					q.offer(new Info(j.vertex, dist+j.dist));
					if(maxDist < dist+j.dist)
					{
						maxDist = dist + j.dist;
						start = j.vertex;
					}
				}
			}
		}
		System.out.println(maxDist);
	}
}
