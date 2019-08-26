package baekjoon.dynamicProgramming;
import java.io.*;

public class b11057 {
	
	public static long mod = 10007L;
	
	public static long [][] d;
	
	public static long go(int n, int l)
	{
		for(int k=0; k<=l; k++)
				d[n][l] = d[n][l] + d[n-1][k];
		return d[n][l] % mod;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long sum = 0; 
		d = new long[t+1][10];
		for(int i=0; i<10 ;i++)
		{
			d[1][i] = 1;
		}
		for(int i=2; i<=t ;i++)
			for(int j=0; j<10; j++)
			{
				d[i][j] = go(i, j); 
			}
		for(int i=0; i<10; i++)
			sum += d[t][i]%mod;
		System.out.println(sum%mod);
		br.close();
	}
}	
