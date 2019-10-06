package baekjoon.math;
import java.util.*;
import java.io.*;


public class b11576 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		int ten = 0;
		int [] arr = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n ;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=n-1; i>=0 ;i--)
		{
			ten = ten + arr[i]* (int)Math.pow(a,n-1-i);
		}
		while(ten != ten / b)
		{
			sb.insert(0, " "+ten%b);
			ten = ten / b;
		}
		System.out.println(sb.toString().substring(1));
	}
}