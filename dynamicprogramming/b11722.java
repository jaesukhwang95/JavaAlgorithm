package baekjoon.dynamicprogramming;
import java.io.*;
import java.util.*;

public class b11722 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] d = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n ;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		d[1] = 1;
		int max = 1;
		for(int i=2; i<=n ; i++)
		{
			max = 1;
			for(int j=1; j<i; j++)
			{
				if(arr[j]>arr[i])
				{
					max = Math.max(max, d[j]+1);
				}
			}
			d[i] = max;
		}
		int ans = 1;
		for(int i=1; i<=n; i++)
		{
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}
}