package baekjoon.dataStructure;
import java.util.*;
import java.io.*;

public class b11725 {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> [] arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
		{
			arr[i] = new ArrayList<Integer>();
		}
		boolean [] visit = new boolean[n+1];
		int [] parent = new int [n+1];
		for(int i=0; i<n-1 ;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		visit[1] = true;
		while(!q.isEmpty())
		{
			int p = q.poll();
			for(int el : arr[p])
			{
				if(!visit[el])
				{
					q.offer(el);
					visit[el] = true;
					parent[el] = p;
				}
			}
		}
		for(int i=2; i<=n ;i++)
		{
			sb.append(parent[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
