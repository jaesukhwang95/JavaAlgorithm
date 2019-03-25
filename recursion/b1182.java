package baekjoon.recursion;
import java.util.Scanner;

public class b1182 {
	public static int cnt = 0;
	
	public static void go(int [] arr, int idx, int res, int sum)
	{
		if(idx==arr.length)
		{
			if(sum==res)
			{
				cnt=cnt+1;
				return;
			}
			else
				return;
		}
		go(arr, idx+1, res, sum);
		go(arr, idx+1, res, sum+arr[idx]);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int res = sc.nextInt();
		int [] arr = new int [num];
		
		
		for(int i=0; i<num ;i++)
			arr[i] = sc.nextInt();
		go(arr, 0, res, 0);
		if(res == 0)
			cnt--;
		System.out.printf("%d\n", cnt);
		sc.close();
	}
}
