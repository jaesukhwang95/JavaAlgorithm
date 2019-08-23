package baekjoon.graph;
import java.io.*;
import java.util.*;

public class b13549 {
	public static void main(String[] args) throws IOException{
		int MAX = 100000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] dist = new int[MAX+1];
		boolean[] visit = new boolean[MAX+1];
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> qNext = new LinkedList<Integer>();
		q.offer(a);
		visit[a] = true;
		dist[a] = 0;
		while(!q.isEmpty())
		{
			int c = q.poll();
			if(2*c<=MAX)
			{
				if(!visit[2*c])
				{
					q.offer(2*c);
					dist[2*c] = dist[c];
					visit[2*c] = true;
				}
			}
			if(c-1>=0)
			{
				if(!visit[c-1])
				{
					qNext.offer(c-1);
					dist[c-1] = dist[c]+1;
					visit[c-1] = true;
				}
			}
			if(c+1<=MAX)
			{
				if(!visit[c+1])
				{
					qNext.offer(c+1);
					dist[c+1] = dist[c]+1;
					visit[c+1] = true;
				}
			}
			if(q.isEmpty())
			{
				q = qNext;
				qNext = new LinkedList<Integer>();
			}
		}
		System.out.println(dist[b]);
	}
}