package baekjoon.graph;

import java.util.*;

public class b4963 {
	
	public static final int dx[]= {1,1,1,0,0,-1,-1,-1};
	public static final int dy[]= {1,0,-1,1,-1,1,0,-1};
	
	public static void dfs (int x,int y, int [][]ox, int [][]count, int cnt, int w, int h)
	{
		if(count[y][x]!=0)
			return;
		
		count[y][x]=cnt;
		for(int i=0; i<8; i++)
		{
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			if(0 <= nx && nx < w && 0 <= ny && ny < h && ox[ny][nx]==1)
			{
				dfs(nx, ny, ox, count, cnt, w, h);
			}
		}
		
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int w = sc.nextInt();
			int h = sc.nextInt();
			int cnt = 0;
			
			if(w==0 && h ==0)
				System.exit(0);
			
			int ox[][] = new int [h][w];
			for(int i=0; i<h ;i++)
				for(int j=0; j<w ;j++)
				{
					ox[i][j] = sc.nextInt();
				}
			int count[][] = new int [h][w];
			for(int i=0; i<h ;i++)
			{
				for(int j=0; j<w ;j++)
				{
					if(ox[i][j]==1 && count[i][j]==0)
					{
						cnt = cnt+1;
						dfs(j, i, ox, count, cnt, w, h);
					}
				}
			}
			
			System.out.printf("%d\n", cnt);
		}
	}
}
