package baekjoon.bruceforce;

import java.util.Scanner;

public class b9095 {
	
	static int d[] = new int[12];

		
	public static int sum(int num)
	{
		
		if(num>3)
		{
			return  sum(num-1) + sum(num-2) + sum(num-3);
		}
		return d[num];
	}
	
	
	
	public static void main(String[] args)
	{
		d[1]=1;
		d[2]=2;
		d[3]=4;
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int inp;
		while(t-->0)
		{
			inp = sc.nextInt();
			System.out.printf("%d\n", sum(inp));
		}
		sc.close();
	}

}
