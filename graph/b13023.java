package baekjoon.graph;
import java.io.*;
import java.util.*;

public class b13023 {
	
	public static class Edge{
		int to;
		int from;
		Edge(int to, int from)
		{
			this.to = to;
			this.from = from;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] g = new ArrayList[n];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		boolean[][] arr = new boolean[n][n];
		boolean signal = false;
		for(int i=0; i<n; i++)
		{
			g[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edges.add(new Edge(from, to));
			edges.add(new Edge(to, from));
			arr[to][from] = true;
			arr[from][to] = true;
			g[from].add(to);
			g[to].add(from);
		}
		Loop:for(int i=0; i<2*m; i++)
			for(int j=0; j<2*m; j++)
			{
				int A = edges.get(i).from;
				int B = edges.get(i).to;
				int C = edges.get(j).from;
				int D = edges.get(j).to;
				if(A != B && A != C && A != D && B != C && B != D && C != D)
				{
					if(arr[B][C])
					{
						for(int E: g[D])
						{
							if(E != A && E != B && E != C && E != D)
							{
								signal = true;
								break Loop;
							}
						}
					}
				}
			}
		if(signal)
		{
			System.out.println(1);
		}
		else
		{
			System.out.println(0);
		}
	}
}
