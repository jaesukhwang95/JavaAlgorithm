package baekjoon.bruceforce;

import java.util.Scanner;

public class b10974 {
	
	public static boolean next(int[] arr)
	{
		int len = arr.length;
		int front = -1;
		int back=-1;
		for(int i = len-1; i>0 ;i--)
		{
			if(arr[i]>arr[i-1])
			{
				front = i-1;	
				break;
			}
		}
		if (front == -1)
		return false;
		
		for(int i = len-1; i>front ;i--)
		{
			if(arr[front]<arr[i])
			{
				back = i;
				break;
			}
		}
		
		int temp = front;
		front = back;
		back= temp;
		
		System.out.printf("%d %d", arr[front], arr[back]);
		return true;
	}

	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int [] arr = new int[num];
		
		for(int i=0;i<num;i++)
		{
			arr[i] = sc.nextInt();
		}
		next(arr);
		
	}
}
