package baekjoon.bruceforce;

import java.util.Scanner;

public class b14888 {

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

		
		
		int temp = arr[front];
		arr[front] = arr[back];
		arr[back]= temp;
		int first = front+1;
		int last = len-1;
		
		while(first<=last)
		{
			temp = arr[first];
			arr[first] = arr[last];
			arr[last]= temp;
			first++;
			last--;
		}
		return true;
	}
	
	
	public static int calc(int a , int b, int op)
	{
		if(op == 1)
			return a+b;
		else if (op==2)
			return a-b;
		else if (op==3)
			return a*b;
		else
			return a/b;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] num = new int [n];
		int [] op = new int [n-1];
		int [] cal = new int [4];
		int j = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n ;i++)
		{
			num[i] = sc.nextInt();
		}
		for(int i=0; i<4; i++)
		{
			cal[i] = sc.nextInt();
		}
		for(int i=0; i<cal[0] ;i++)
		{
			op[j] = 1;
			j++;
		}
		for(int i=0; i<cal[1] ;i++)
		{
			op[j] = 2;
			j++;
		}
		for(int i=0; i<cal[2] ;i++)
		{
			op[j] = 3;
			j++;
		}
		for(int i=0; i<cal[3] ;i++)
		{
			op[j] = 4;
			j++;
		}
		boolean jud = true;
		
		while(jud)
		{
			sum = calc(num[0], num[1], op[0]);
			for(int i=1; i<n-1 ;i++)
				sum = calc(sum, num[i+1], op[i]);
			if(sum<min)
			{
				min = sum;
			}
			if(sum>max)
			{
				max = sum;
			}
			jud = next(op);
		}
		System.out.printf("%d\n", max);
		System.out.printf("%d\n", min);
		sc.close();
	}
}
