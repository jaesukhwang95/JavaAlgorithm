package baekjoon.graph;
import java.io.*;
import java.util.*;

public class b1697 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean []visit = new boolean[100001];
		int []dist = new int[100001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		visit[n] = true;
		dist[n] = 0;
		while(!q.isEmpty())
		{
			int a = q.poll();
			if(a-1>=0)
			{
				if(!visit[a-1])
				{
					q.offer(a-1);
					visit[a-1] = true;
					dist[a-1] = dist[a]+1;
				}
			}
			if(a+1<=100000)
			{
				if(!visit[a+1])
				{
					q.offer(a+1);
					visit[a+1] = true;
					dist[a+1] = dist[a]+1;
				}
			}
			if(a*2<=100000)
			{
				if(!visit[a*2])
				{
					q.offer(a*2);
					visit[a*2] = true;
					dist[a*2] = dist[a]+1;
				}
			}
		}
		System.out.println(dist[m]);
		br.close();
	}
}
