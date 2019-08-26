package baekjoon.dynamicprogramming;
import java.io.*;
import java.util.*;

public class b11053 {
	
	public static int[] d;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		d = new int[n];
		d[0] = 1;
		int max = 1;
		for(int i=1; i<n; i++)
		{
			max =1;
			for(int j=0; j<i; j++)
			{
				if(arr[i] > arr[j])
					max = Math.max(max, d[j]+1);
			}
			d[i]=max;
		}
		int res = 1;
		for(int i=0; i<n ; i++)
		{
			res = Math.max(res, d[i]);
		}
		System.out.println(res);
		for(int i=0; i<n ;i++)
		System.out.println(d[i]);
		br.close();
	}
}
