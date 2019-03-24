package baekjoon.math;

import java.util.Scanner;

public class b1929 {

	public static boolean prime (int num)
	{
		int cnt = 0;
		if(num==1)
		return false;
		
		for(int i=1; i*i<=num; i++)
		{
			if(num%i==0)
			cnt++;
		}
		if(cnt==1)
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		int num;
		int pn=0;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			num = sc.nextInt();
			if(num==0)
				break;
			for(int i=2;i<=num/2;i++)
			{
				if(prime(i) && prime(num-i))
				{
					pn = i;
					System.out.printf("%d = %d + %d\n", num, pn, num-pn);
					break;
				}
			}
			if(pn==0)
				System.out.printf("Goldbach's conjecture is wrong.");
			
		}
		sc.close();
	}
}
