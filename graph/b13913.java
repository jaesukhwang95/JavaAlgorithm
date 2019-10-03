package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b13913 {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [] dist = new int [100001];
		int [] before = new int [100001];
		for(int i=0; i<=100000 ;i++)
		{
			before[i] = -1;
		}
		boolean [] visit = new boolean [100001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		visit[n] = true;
		while(!q.isEmpty())
		{
			int a = q.poll();
			if(a>=1  && !visit[a-1])
			{
				before[a-1] = a;
				q.offer(a-1);
				visit[a-1] = true;
				dist[a-1] = dist[a] + 1;
			}
			if(a<=99999 && !visit[a+1])
			{
				before[a+1] = a;
				q.offer(a+1);
				visit[a+1] = true;
				dist[a+1] = dist[a] + 1;
			}
			if(2*a<=100000 && !visit[a*2])
			{
				before[a*2] = a;
				q.offer(a*2);
				visit[a*2] = true;
				dist[a*2] = dist[a] + 1;
			}
		}
		System.out.println(dist[k]);
		Stack<Integer> s = new Stack<Integer>();
		s.push(k);
		while(before[k] != -1)
		{
			s.push(before[k]);
			k = before[k];
		}
		while(!s.isEmpty())
		System.out.print(s.pop()+" ");
		System.out.println();
	}
}
