package baekjoon.bruteForce;
import java.util.*;
import java.io.*;

public class b1208 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int [] arr = new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = arr[0];
		int i = 0;
		int j = 0;
		int ans = Integer.MAX_VALUE;
		while(i <= j && j < n)
		{
			if(sum < s)
			{
				j++;
				sum += arr[j];
			}
			else if(sum == s)
			{
				ans = Math.min(j-i+1, ans);
				j++;
				sum += arr[j];
			}
			else if(sum > s)
			{
				ans = Math.min(j-i+1, ans);
				sum -= arr[i];
				i++;
			}
		}
	}

}
