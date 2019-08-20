package baekjoon.samsung;
import java.util.*;

public class s2072 {
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int sum = 0;
			int [] num = new int[10];
			for(int i=0; i<10; i++)
			{
				num[i] = sc.nextInt();
			}
			for(int i=0; i<10; i++)
			{
				if(num[i]%2 == 1)
				{
					sum += num[i];
				}
			}
			System.out.printf("#%d %d", 3-t, sum);
			System.out.println();
		}
		sc.close();
	}
}	
