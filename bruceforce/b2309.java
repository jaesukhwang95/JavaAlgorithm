package baekjoon.bruceforce;

import java.util.Scanner;
import java.util.Arrays;

class b2309 {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int arr[] = new int [9];
		int sum=0;
		int two;
		for(int i=0; i<9 ;i++)
		{
			arr[i] = sc.nextInt();
			sum = sum + arr[i];
		}
		Arrays.sort(arr);
		for(int i=0; i<8 ;i++)
			{
				for(int j=i+1; j<9 ;j++)
				{
					two = arr[i] + arr[j];
					if(sum - two == 100)
					{
						for(int k=0; k< 9; k++)
						{
							if(k != i && k != j)
								System.out.printf("%d\n", arr[k]);
						}
						System.exit(0);
					}
				}
			}
		
		
		sc.close();
	}
}
