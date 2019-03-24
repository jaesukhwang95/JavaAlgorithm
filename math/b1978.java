package baekjoon.math;

import java.util.Scanner;

public class b1978 {
	
	public static boolean prime(int num) {
		int cnt = 0;
		if(num == 1)
			return false;
		
		for(int i=1; i*i <= num ;i++)
		{
			if(num%i==0)
			{
				cnt++;
			}
		}
		if(cnt==1)
		{
			return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int cnt=0;
		int num;
		while(t-->0)
		{
			num = sc.nextInt();
			if(prime(num))
			{
				cnt++;
			}
		}
		System.out.print(cnt);
		sc.close();
	}
}
