package baekjoon.graph;

import java.util.*;


public class b13023{
		
		static ArrayList<Integer>[] a;
		static boolean [] c;
		static boolean ans = false;
		
		public static void dfs(int x, int cnt)
		{
			if(c[x])
				return;
			if(cnt == 5)
			{
				ans = true;
				return;
			}
			c[x] = true;
			for(int i : a[x])
			{
				if(c[i])
					continue;
				if(!c[i])
					dfs(i, cnt+1);
			}
		}
		
	    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	int n = sc.nextInt();
	    	int m = sc.nextInt();
	    	a = (ArrayList<Integer>[]) new ArrayList[n];
	    	for(int i=0; i<n; i++)
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
	    	for(int i=0; i<n ;i++)
	    		Collections.sort(a[i]);
	    	for(int i=0; i<n ;i++)
	    	{
	    		c = new boolean[n];
	    		dfs(i,1);
	    		if (ans)
	    		{
	    			System.out.println(1);
	    			System.exit(0);
	    		}
	    	}
	    	System.out.println(0);
	    }
}