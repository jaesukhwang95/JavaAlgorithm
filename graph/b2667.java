package baekjoon.graph;

import java.util.*;

public class b2667 {
	
	public static final int dx[] = {1,-1, 0, 0};
	public static final int dy[] = {0,0, -1, 1};
	
	public static void dfs(int x, int y, int cnt, int [][]ox, int[][]group, int n)
	{
		if(group[x][y]!=0)
			return;
		group[x][y] = cnt;
		for(int i=0; i<4 ;i++)
		{
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(0 <= nx && nx< n && 0 <= ny && ny< n)
			{
				if(ox[nx][ny]==1 && group[nx][ny]==0)
				{
					dfs(nx, ny, cnt, ox, group, n);
				}
			}
		}
		
		
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [][] ox = new int [t][t];
		int [][] group = new int [t][t];
		int cnt = 0;
		
		for(int i=0; i<t ;i++)
		{
			String s = sc.next();
			for(int j=0; j<t ;j++)
		{
			ox[i][j] = s.charAt(j)-'0';
		}
		}
		
		for(int i=0; i<t ;i++)
		{
			for(int j=0; j<t ;j++)
			{
				if(ox[i][j]==1 && group[i][j]==0)
				{
					cnt += 1;
					dfs(i, j, cnt, ox, group, t);
				}
			}
		}
		
		int [] ans =new int [cnt];
		for(int i=0; i<t ;i++)
			for(int j=0; j<t ;j++)
			{
				if(group[i][j]!=0)
					ans[group[i][j]-1] += 1;
			}
		
		
		Arrays.sort(ans);
		System.out.printf("%d\n", cnt);
		for(int i=0; i<cnt ;i++)
		{
			System.out.printf("%d\n", ans[i]);
		}
	}

}
//7
//0110100
//0110101
//1110101
//0000111
//0100000
//0111110
//0111000