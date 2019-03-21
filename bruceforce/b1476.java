package baekjoon.bruceforce;

import java.util.Scanner;


public class b1476 {

	public static void main(String[] args)
	{
		int day = 0;
		Scanner sc = new Scanner(System.in);
		int date [] = new int [3];
		int e, s, m;
		date[0] = 0;
		date[1] = 0;
		date[2] = 0;

		e = sc.nextInt();
		s = sc.nextInt();
		m = sc.nextInt();
		
		sc.close();

		while(true)
		{
			for(int i=0; i<3 ;i++)
			date[i]++;
			if(date[0] == 16)
				date[0] = 1;
			if(date[1] == 29)
				date[1] = 1;
			if(date[2] == 20)
				date[2] = 1;
			day = day +1;
			if(date[0] == e && date[1] == s && date[2] == m)
				{
					System.out.printf("%d\n", day);
					System.exit(0);
				}
		}
	}
}
