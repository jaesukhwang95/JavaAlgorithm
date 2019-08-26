package baekjoon.dynamicProgramming;
import java.io.*;
import java.util.*;

public class b11054 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] inc = new int[n+1];
		int[] dec = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n ;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++)
		{
			inc[i] = 1;
			for(int j=1; j<i; j++)
			{
				if(arr[i] > arr[j] && inc[i] < inc[j]+1)
				{
					inc[i] = inc[j] + 1;
				}
			}
		}
		for(int i=n; i>=1; i--)
		{
			dec[i] = 1;
			for(int j=n; j>i ; j--)
			{
				if(arr[i] > arr[j] && dec[i] < dec[j]+1)
				{
					dec[i] = dec[j] + 1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=n ; i++)
		{
			max = Math.max(max, inc[i]+dec[i]-1);
		}
		System.out.println(max);
	}
}