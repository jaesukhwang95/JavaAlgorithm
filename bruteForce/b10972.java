package baekjoon.bruteForce;

import java.util.Scanner;


public class b10972 {
	
	public static void swap(int [] arr, int a, int b)
	{
		int temp = 0;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static int next(int[] arr)
	{
		int leng = arr.length;
		int front = -1;
		int back = -1;
		int k = 1;
		for(int j=leng-1; j>=1 ;j--)
		{
			if(arr[j]>arr[j-1])
			{
				front = j-1;
				break;
			}
		}
		if(front != -1)
		{
			for(int j=leng-1;j>=0 ;j--)
			{
				
				if(arr[front]<arr[j])
				{
					back=j;
					break;
				}
			}
			swap(arr, front, back);
			
			while(front+k<=leng-k)
			{
				swap(arr, front+k,  leng-k);
				k++;
			}

		}
		return front;
		
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int [] arr = new int[len];
		for(int i=0;i<len;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		int front = next(arr);
		if(front==-1)
		{
			System.out.println("-1");
		}
		else{
			for(int i=0; i<len ;i++)
				System.out.printf("%d ", arr[i]);
				System.out.println();
				sc.close();
		}
		
	}

}
