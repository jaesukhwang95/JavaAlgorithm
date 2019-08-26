package baekjoon.dynamicprogramming;
import java.io.*;
import java.util.*;

public class b2225 {
	
	public static long [][] d;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long mod = 1000000000L;
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		d = new long[n+1][k+1];
		
		for(int i=1; i<=n; i++)
		{
			d[i][1] = 1;
		}
		for(int i=1; i<=k; i++)
		{
			d[0][i] = 1;
		}
		for(int i=1; i<=n; i++)
			for(int j=2; j<=k; j++)
				for(int l=0; l<=i; l++)
				{
					d[i][j] += d[i-l][j-1]%mod;
				}
		System.out.println(d[n][k]%mod);
	}
}