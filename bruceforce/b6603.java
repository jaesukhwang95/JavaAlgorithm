package baekjoon.bruceforce;
import java.util.Scanner;

public class b6603 {
	
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
		int [] sel = new int [6];
		int j = 0;
		while(true)
		{
			int num = sc.nextInt();
			if(num==0)
				sc.close();
				System.exit(0);
			int [] arr = new int [num];
			int [] idx = new int [num];
			for(int i=0; i<num ;i++)
			{
				arr[i] = sc.nextInt();
			}
			for(int i=0; i<6 ;i++)
			{
				idx[i] = 1;
			}
			for(int i=6; i<num ;i++)
			{
				idx[i] = 2;
			}
			boolean jud = true;
			while(jud)
			{
				j = 0;
				for(int i=0; i<num ;i++)
				{
					if(idx[i]==1)
					{
						sel[j] = arr[i];
						System.out.printf("%d ", sel[j]);
						j++;
					}
				}
				System.out.println();
				jud = next(idx);
			}
			System.out.println();
		}
		
	}
}
