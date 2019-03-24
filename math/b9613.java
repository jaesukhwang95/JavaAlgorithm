package baekjoon.math;
import java.util.Scanner;
import java.math.BigInteger;


public class b9613 {
	
	public static int gcd(int a, int b)
	{
		while(b != 0)
		{
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
			
		{
			BigInteger sum = new BigInteger("0");

			int m = sc.nextInt();
			int[] a = new int[m];
			for(int i=0; i<m; i++)
			{
				a[i] = sc.nextInt();
			}
			for(int i=0; i<m; i++)
				{
					for(int j=i+1; j<m; j++)
						sum = sum.add(BigInteger.valueOf(gcd(a[i],a[j])));
				}
				System.out.printf("%d\n", sum);
 			
		}
		sc.close();
	}
}
