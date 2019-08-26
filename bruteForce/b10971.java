package baekjoon.bruteForce;
import java.util.Scanner;

public class b10971 {

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
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int fixed = num;
		int [][] arr1 = new int [num][num];
		while(num-->0)
		{
			for(int i=0; i<fixed ;i++)
			{
				arr1[fixed-num-1][i] = sc.nextInt();
			}
		}
		int arr2 [] = new int [fixed];
		for(int i=0; i<fixed ;i++)
		{
			arr2[i] = i;
		}
		int sum = Integer.MAX_VALUE ;
		boolean jud = true;
		int min = sum;
		while(jud)
		{
			sum = 0;
			for(int i=0; i<fixed-1 ;i++)
			{
				sum = sum + arr1[arr2[i]][arr2[i+1]];
			}
			sum = sum + arr1[arr2[fixed-1]][arr2[0]];
			for(int i=0; i<fixed-1 ;i++)
			{
				if(arr1[arr2[i]][arr2[i+1]]==0)
					sum = Integer.MAX_VALUE ;
			}
			if(arr1[arr2[fixed-1]][arr2[0]]==0)
				sum = Integer.MAX_VALUE;
			if(sum<min)
				min = sum;
			jud = next(arr2);
		}
		System.out.printf("%d\n", min);
		sc.close();
	}
}
