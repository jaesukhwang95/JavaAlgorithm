package baekjoon.recursion;
import java.io.*;

public class b9663 {
	static int n;
	static int cnt = 0;
		
	public static void go(int [] col, int level)
	{
		if(level == n)
		{
			cnt++;
			return;
		}
		for(int i=0; i<n ;i++)
		{
			col[level] = i;
			if(check(col, level))
			{
				go(col, level+1);
			}
			col[level] = 0;
		}
	}

	public static boolean check(int [] col, int level)
	{
		for(int i=0; i<level ;i++)
		{
			if(col[level] == col[i] || Math.abs(level-i) == Math.abs(col[level]-col[i]))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	
		int [] col = new int [n];
		go(col, 0);
		System.out.println(cnt);
	}
}