package baekjoon.bruteForce;
import java.util.*;
import java.io.*;

public class b2003 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int [] arr = new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int cnt = 0;
		for(int i=0; i<n ;i++)
		{
			sum = 0;
			for(int j=i; j<n; j++)
			{
				sum += arr[j];
				if(sum>m)
				{
					break;
				}
				if(sum==m)
				{
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
