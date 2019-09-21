package baekjoon.bruteForce;
import java.util.*;
import java.io.*;

public class b1107 {
	
	public static int dist(String str, int[] arr)
	{
		for(int i=0; i<arr.length ;i++)
		{
			for(int j=0; j<str.length(); j++)
			{
				if(str.charAt(j)-'0' == arr[i])
					return -1;
			}
		}
		return str.length();
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int channel = Integer.parseInt(str);
		int ans;
		int n = Integer.parseInt(br.readLine());
		if(n == 0)
		{
			ans = Math.min(Math.abs(channel-100), String.valueOf(channel).length());
		}
		else
		{
			int [] arr = new int [n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0; i<n ;i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			ans = Math.abs(channel-100);
			for(int i=0; i<=1000000 ;i++)
			{
				String num = String.valueOf(i);	
				int distance = dist(num, arr);
				if( distance == -1)
				{
					continue;
				}
				else
				{
					ans = Math.min(ans, distance+Math.abs(channel-i));
				}
			}
		}
		System.out.println(ans);
	}
}
