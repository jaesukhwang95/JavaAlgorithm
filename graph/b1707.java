package baekjoon.graph;

import java.util.*;

public class b1707 {
	
	public static ArrayList<Integer>[] a;
	public static boolean ans=true;
	
	public static void dfs(int x, int clr, int [] color)
	{
		if(color[x]!=0)
			return;
		color[x] = clr;
		for(int i:a[x])
		{
			if(color[i]==0)
				dfs(i, 3-clr, color);
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		while(total-->0)
		{
			ans = true;
			int n = sc.nextInt();
			int m = sc.nextInt();
			a = (ArrayList<Integer>[]) new ArrayList[n+1];
			for(int i=1; i<=n ;i++)
			{
				a[i] = new ArrayList<Integer>();
			}
			int [] color = new int [n+1];
			Arrays.fill(color,0);
			for(int i=1; i<=m ;i++)
			{
				int u = sc.nextInt();
				int v = sc.nextInt();
				a[u].add(v);
				a[v].add(u);
			}
			for(int i=1; i<=n ;i++)
			{
				Collections.sort(a[i]);	
			}
			for(int i=1; i<=n ;i++)
			{
				if(color[i] == 0)
				dfs(i, 1, color);
			}
			for(int i=1; i<=n; i++)
			{
				for(int j: a[i])
				{
					if(color[i] == color[j])
						ans = false;
				}
			}
			if(ans)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}