package baekjoon.recursion;
import java.util.Scanner;

public class b9095 {
	
	public static int go(int sum, int goal)
	{
		if(sum > goal)
			return 0;
		if(sum == goal)
			return 1;
		int now = 0;
		for(int i=1;i<=3;i++)
		{
			now = now + go(sum+i, goal);
		}
			return now;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int result = 0;
		while(num-->0)
		{
			int total = sc.nextInt();
			result = go(0, total);
			System.out.printf("%d\n", result);
		}
		sc.close();
	}

}


