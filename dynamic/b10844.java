package baekjoon.dynamic;
import java.util.*;

public class b10844 {
	
	public static long mod = 1000000000L;
	
	public static long[][] d;
	
	public static long go (int n, int l)
	{
		d[n][l] = 0;
		if(l != 0 && l != 9)
		{
			d[n][l] = d[n-1][l-1] + d[n-1][l+1];
		}
		else if (l == 0)
		{
			d[n][l] = d[n-1][l+1];
		}
		else
		{
			d[n][l] = d[n-1][l-1];
		}
		return d[n][l] % mod;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long sum = 0;
		d = new long[t+1][10];
		for(int i=1; i<10; i++)
		{
			d[1][i] = 1;
		}
		for(int i=2; i<=t; i++)
		{
			for(int j=0; j<10; j++)
			{
				d[i][j] = go(i, j);
			}
		}
		for (int i=0; i<10; i++) {
            sum += d[t][i];
        }
		System.out.println(sum%mod);
		sc.close();
	}
}
