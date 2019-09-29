package baekjoon.math;
import java.util.*;
import java.io.*;

public class b1644 {
	
	public static int [] prime;
	public static int cnt = 0;
	public static boolean [] arr;
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		arr = new boolean [n+1];
		prime = new int [283147];
		for(int i=2; i<=n; i++)
		{
			if(arr[i])
			{
				continue;
			}
			for(int j=i+i; j<=n; j=j+i)
			{
				arr[j] = true;
			}
		}
		for(int i=2; i<=n; i++)
		{
			if(!arr[i])
			{
				prime[cnt] = i;
				cnt++;
			}
		}
		int left = 0;
		int right = 0;
		int sum = prime[0];
		while(left <= right && right < cnt)
		{
			if(sum < n)
			{
				right++;
				sum += prime[right];
			}
			else if(sum == n)
			{
				ans++;
				right++;
				sum += prime[right];
				
			}
			else if(sum > n)
			{
				sum -= prime[left];
				left++;
			}	
		}
		System.out.println(ans);
		sc.close();
	}
}