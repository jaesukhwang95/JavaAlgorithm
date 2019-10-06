package baekjoon.math;
import java.util.*;

public class b2089 {
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		if(n == 0)
			System.out.println(0);
		else
		{
			while(true)
			{
				if(n>0)
				{
					sb.insert(0, n%2);
					n = -(n/2);
				}
				else if(n<0)
				{
					if(n%2==0)
					{
						sb.insert(0, 0);
						n = -(n/2);
					}
					else
					{
						sb.insert(0, 1);
						n = (-n+1)/2;
					}
				}
				else
				{
					break;
				}
			}
			System.out.println(sb.toString());
		}
		sc.close();		
	}
}