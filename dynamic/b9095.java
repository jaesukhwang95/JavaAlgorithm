package baekjoon.dynamic;
import java.util.*;

public class b9095 {
	
	public static int[] d;
	
	public static int go(int n)
	{
		if(n==1)
		{
			return 1;
		}
		if(n==2)
		{
			return 2;
		}
		if(n==3)
		{
			return 4;
		}
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		for(int i=4; i<=n ;i++)
		{
			d[i] = d[i-1] + d[i-2] + d[i-3];
		}
		return d[n];
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-->0)
		{
			int m = sc.nextInt();
			d = new int[m+1];
			System.out.println(go(m));
		}
		sc.close();
	}
}
