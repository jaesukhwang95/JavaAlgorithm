package baekjoon.math;
import java.util.Scanner;

public class b2609 {
	
	public static int GCD(int a, int b)
	{

		int gcd = 1;
		int min = (a>b) ? b : a;
		for(int i=1; i<= min; i++)
		{
			if(a%i==0 && b%i==0)
			{
				gcd = i;
			}
		}
		return gcd;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.printf("%d\n", GCD(a,b));
		System.out.printf("%d\n", a*b/GCD(a,b));

		sc.close();
	}
}
