package baekjoon.dataStructure;
import java.util.*;
import java.io.*;

public class b1167 {
	
	public static class Node
	{
		int vertex;
		int dist;
		Node(int vertex, int dist)
		{
			this.vertex = vertex;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Node> [] arr = new ArrayList[n+1];
		for(int i=1; i<=n ;i++)
		{
			arr[i] = new ArrayList<Node>();
		}
		for(int i=1; i<=n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			while(true)
			{
				int vertex = Integer.parseInt(st.nextToken());
				if(vertex == -1)
					break;
				int dist = Integer.parseInt(st.nextToken());
				arr[idx].add(new Node(vertex, dist));
			}
		}
		boolean [] visit = new boolean [n+1];
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(1, 0));
		int start = 1;
		int maxDist = 0;
		visit[1] = true;
		while(!q.isEmpty())
		{
			Node node = q.poll();
			int vertex = node.vertex;
			int dist = node.dist;
			for(Node next : arr[vertex])
			{
				if(!visit[next.vertex])
				{
					visit[next.vertex] = true;
					q.offer(new Node(next.vertex,dist+next.dist));
					if(maxDist<dist+next.dist)
					{
						maxDist = dist+next.dist;
						start = next.vertex;
					}
				}
			}
		}
		visit = new boolean [n+1];
		maxDist = 0;
		q.offer(new Node(start, 0));
		visit[start] = true;
		while(!q.isEmpty())
		{
			Node node = q.poll();
			int vertex = node.vertex;
			int dist = node.dist;
			for(Node next : arr[vertex])
			{
				if(!visit[next.vertex])
				{
					visit[next.vertex] = true;
					q.offer(new Node(next.vertex,dist+next.dist));
					if(maxDist<dist+next.dist)
					{
						maxDist = dist+next.dist;
					}
				}
			}
		}
		System.out.println(maxDist);
	}
}
