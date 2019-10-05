package baekjoon.math;
import java.util.*;

public class b1676 {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int five = 0;
		int two = 0;
		for(int i=2; i<=N ;i=i*2)
		{
			two += N/i;
		}
		for(int i=5; i<=N; i=i*5)
		{
			five += N/i;
		}
		int ans = two > five ? five : two;
		System.out.println(ans);
		sc.close();
	}
}
