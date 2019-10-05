package baekjoon.math;
import java.util.*;

public class b2004 {
	
	public static long fiveCount(long a)
	{
		long five = 0;
		for(long i=5; i<=a ;i=i*5)
		{
			five += a/i;
		}
		return five;
	}
	
	public static long twoCount(long a)
	{
		long two = 0;
		for(long i=2; i<=a ;i=i*2)
		{
			two += a/i;
		}
		return two;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String [] str = new String [2];
		str = sc.nextLine().split(" ");
		long n = Long.parseLong(str[0]);
		long m = Long.parseLong(str[1]);
		long two = twoCount(n)-twoCount(n-m)-twoCount(m);
		long five = fiveCount(n)-fiveCount(n-m)-fiveCount(m);
		long ans = two > five ? five : two;
		System.out.println(ans);
		sc.close();
	}
}