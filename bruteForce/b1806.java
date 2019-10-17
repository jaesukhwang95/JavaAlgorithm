package baekjoon.bruteForce;
import java.io.*;
import java.util.*;

public class b1806 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int len = Integer.MAX_VALUE;
		int right = 0;
		int left = 0;
		int [] arr = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n ;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		while(left <= right && right <= n)
		{
			if(sum<s)
			{
				if(right<n)
				{
					sum += arr[right];
			 		right++;
				}
				else
					break;
			}
			else if(sum >= s)
			{
				if(left<=right)
				{				
					sum -= arr[left];
					left++;
					len = Math.min(len, right-left+1);
				}
				else
					break;
			}
		}
		if(len == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(len);
	}
}
