package baekjoon.dynamicprogramming;
import java.util.*;

public class b11726 {
	
	public static int[] d;
	
	public static int go(int n)
	{
		if(n==1)
		{
			return 1;
		}
		else if(n==2)
		{
			return 2;
		}
		d[1] = 1;
		d[2] = 2;
		for(int i=3; i<=n ;i++)
		{
			d[i] = d[i-1] % 10007 + d[i-2] % 10007;
		}
		return d[n];
	}

	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n+1];
		int result = go(n) % 10007;
		System.out.println(result);
		sc.close();
	}
}
