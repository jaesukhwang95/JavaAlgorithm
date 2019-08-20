package baekjoon.dynamic;
import java.io.*;

public class b2193 {
	public static long[][] d;
	
	public static long go(int i, int j)
	{
		if(j==1)
			d[i][j] = d[i-1][j-1];
		else
			d[i][j] = d[i-1][j] + d[i-1][j+1];
		return d[i][j];
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long sum = 0;
		int n = Integer.parseInt(br.readLine());
		d = new long[n+2][2];
		d[1][1] = 1;
		d[1][0] = 0;
		d[2][1] = 0;
		d[2][0] = 1;
		for(int i=3; i<=n; i++)
		{
			d[i][1] = go(i, 1);
			d[i][0] = go(i, 0);
		}
		sum = d[n][1] + d[n][0];
		System.out.println(sum);
	}
}
