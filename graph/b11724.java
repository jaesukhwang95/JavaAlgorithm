package baekjoon.graph;
import java.util.*;

public class b11724 {
	
	public static boolean c[];
	public static ArrayList<Integer>[] a;
	public static void dfs(int x)
	{
		if(c[x])
			return;
		c[x]= true;
		for(int i: a[x])
		{
			if(!c[i])
				dfs(i);
		}
		
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		a = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int  i=1; i<=n ;i++)
		{
			a[i] = new ArrayList<Integer>();
		}
		c = new boolean [n+1];
		for(int i=1; i<=m ;i++)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		for(int i=1; i<=n ;i++)
			Collections.sort(a[i]);
		for(int i=1; i<=n ;i++)
		{
			if(!c[i])
			{
			dfs(i);
			cnt++;
			}
		}
		System.out.print(cnt);
	}

}