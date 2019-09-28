package baekjoon.samsung.level2;
import java.io.*;
import java.util.*;

public class s1979 {
	
	public static int [][] arr;
	public static boolean [][] visit;
	public static int n, m, cnt;
	
	public static void xDfs(int i, int j)
	{
		if(visit[i][j] || arr[i][j]==0)
			return;
		cnt++;
		visit[i][j] = true;
		if(j+1<=n)
		{
			if(arr[i][j+1]==1 && !visit[i][j+1])
				xDfs(i, j+1);
		}
	}
	
	public static void yDfs(int i, int j)
	{
		if(visit[i][j] || arr[i][j]==0)
			return;
		cnt++;
		visit[i][j] = true;
		if(i+1<=n)
		{
			if(arr[i+1][j]==1 && !visit[i+1][j])
				yDfs(i+1, j);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		cnt = 0;
		int l = 1;
		while(t-->0)
		{
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n+1][n+1];
			visit = new boolean[n+1][n+1];
			for(int i=1; i<=n; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=n; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int i=1; i<=n ;i++)
			{
				for(int j=1; j<=n; j++)
				{
					xDfs(i,j);
					if(cnt==m)
						ans += 1;
					cnt = 0;
				}
			}
			visit = new boolean[n+1][n+1];
			for(int i=1; i<=n ;i++)
			{
				for(int j=1; j<=n; j++)
				{
					yDfs(i,j);
					if(cnt==m)
						ans += 1;
					cnt = 0;
				}
			}
			sb.append("#").append(l).append(" ").append(ans).append("\n");
			l++;
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
