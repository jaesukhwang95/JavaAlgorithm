package baekjoon.bruceforce;

import java.util.Scanner;

public class b9095 {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		while(total-->0)
		{
			int ans = 0;
			int number = sc.nextInt();
			for(int l0=1; l0<=3 ;l0++)
			{
				if(l0==number) ans = ans + 1;
				for(int l1=1; l1<=3 ;l1++)
				{
					if(l0+l1==number) ans = ans + 1;
					for(int l2=1; l2<=3 ;l2++)
					{
						if(l0+l1+l2==number) ans = ans + 1;
						for(int l3=1; l3<=3 ;l3++)
						{
							if(l0+l1+l2+l3==number) ans = ans + 1;
							for(int l4=1; l4<=3 ;l4++)
							{
								if(l0+l1+l2+l3+l4==number) ans = ans + 1;
								for(int l5=1; l5<=3 ;l5++)
								{
									if(l0+l1+l2+l3+l4+l5==number) ans = ans + 1;
									for(int l6=1; l6<=3 ;l6++)
									{
										if(l0+l1+l2+l3+l4+l5+l6==number) ans = ans + 1;
										for(int l7=1; l7<=3 ;l7++)
										{
											if(l0+l1+l2+l3+l4+l5+l6+l7==number) ans = ans + 1;
											for(int l8=1; l8<=3 ;l8++)
											{
												if(l0+l1+l2+l3+l4+l5+l6+l7+l8==number) ans = ans + 1;
												for(int l9=1; l9<=3 ;l9++)
												{
													if(l0+l1+l2+l3+l4+l5+l6+l7+l8+l9==number) ans = ans + 1;
												}
											}
										}
									}
								}
							}	
						}
					}
				}		
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
