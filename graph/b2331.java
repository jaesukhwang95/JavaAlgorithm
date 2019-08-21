package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b2331 {
	
	private static int[] visit;
	
	
	public static int cal(int num, int p)
	{
		int sum = 0;
		while(num != num/10)
		{
			sum += Math.pow(num%10, p);
			num = num/10;
		}
		return sum;
	}
	
	public static int dfs(int num, int p , int cnt)
	{
		if(visit[num] != 0)
			return visit[num]-1;
		visit[num] = cnt;
		num = cal(num, p);
			return dfs(num, p, cnt+1);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		visit = new int [1000000];
		System.out.println(dfs(s, p, 1));
		br.close();
	}
}