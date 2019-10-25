package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

public class b11066 {

	public static long[][] page = new long[501][501];
	public static int[] sum = new int [501];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] arr = new int [n+1];
			for(int i=1; i<=n ;i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + arr[i];
			}
			for(int i=1; i<=n; i++)
				for(int j=1; j<=n; j++)
					page[i][j] = Integer.MAX_VALUE;
			
			for(int i=1; i<=n; i++)
				page[i][i] = 0;
			
			for(int i=1; i<n ;i++)
			{
				page[i][i+1] = arr[i] + arr[i+1];
			}
			
			for(int k=2; k<n ;k++)
			{
				for(int i=1; i+k<=n ;i++)
				{
					for(int j=i; j<=i+k-1 ;j++)
					page[i][i+k] = Math.min(page[i][i+k], page[i][j] + page[j+1][i+k] + sum[i+k] - sum[i-1]);
				}
			}
			System.out.println(page[1][n]);
		}
	}
}