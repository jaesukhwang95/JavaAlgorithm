package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b12851 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [] cnt = new int [100001];
		int [] dist = new int [100001];
		boolean [] visit = new boolean [100001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		cnt[n] = 1;
		visit[n] = true;
		while(!q.isEmpty())
		{
			int a = q.poll();
			if(a>=1)
			{
				if(!visit[a-1])
				{
					visit[a-1] = true;
					dist[a-1] = dist[a] + 1;
					cnt[a-1] = cnt[a];
					q.offer(a-1);
				}
				else if(dist[a-1] == dist[a] + 1)
				{
					cnt[a-1] += cnt[a];
				}
			}
			if(a<=99999)
			{
				if(!visit[a+1])
				{
					visit[a+1] = true;
					dist[a+1] = dist[a] + 1;
					cnt[a+1] = cnt[a];
					q.offer(a+1);
				}	
				else if(dist[a+1] == dist[a] + 1)
				{
					cnt[a+1] += cnt[a];
				}
			}
			if(a<=50000)
			{
				if(!visit[2*a])
				{
					visit[2*a] = true;
					dist[2*a] = dist[a] + 1;
					cnt[2*a] = cnt[a];
					q.offer(2*a);
				}
				else if(dist[2*a] == dist[a] + 1)
				{
					cnt[2*a] += cnt[a];
				}
			}
		}
		System.out.println(dist[k]);
		System.out.println(cnt[k]);
	}
}
