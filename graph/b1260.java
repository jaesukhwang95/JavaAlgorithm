package baekjoon.graph;
import java.util.*;

public class b1260 {
	static ArrayList<Integer>[] a;
	static boolean[] c;
	
	public static void dfs(int x)
	{
		if(c[x])
			return;
		c[x]=true;
		System.out.print(x + " ");
		for(int i: a[x])
		{
			if(!c[i])
				dfs(i);
		}
		
	}
	
	public static void bfs(int x)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		c[x] = true;
		while(!q.isEmpty())
		{
			int y = q.remove();
			System.out.print(y + " ");
			for(int i: a[y])
			{
				if(!c[i])
				{
					c[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		a = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i=1; i<=n; i++)
		{
			a[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m ;i++)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		for(int i=1; i<=n; i++)
		{
			Collections.sort(a[i]);
		}
		c = new boolean[n+1];
		dfs(start);
		System.out.println();
		c = new boolean[n+1];
		bfs(start);
	}
}
