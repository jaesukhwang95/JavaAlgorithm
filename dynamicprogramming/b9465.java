package baekjoon.dynamicProgramming;
import java.io.*;
import java.util.*;

public class b9465 {
	
	public static int[][] d;
	public static void go(int n , int[][] arr)
	{
			d[n][0] = Math.max(Math.max(d[n-1][0], d[n-1][1]), d[n-1][2]);
			d[n][1] = Math.max(d[n-1][0], d[n-1][2]) + arr[0][n];
			d[n][2] = Math.max(d[n-1][0], d[n-1][1]) + arr[1][n];
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int [2][n+1];
			d = new int[n+1][3];
			for(int i=0; i<2; i++)
			{	
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<n+1 ; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			d[1][0]= 0;
			d[1][1] = arr[0][1];
			d[1][2] = arr[1][1];
			for(int j=2; j<n+1 ; j++)
				go(j, arr);
			System.out.println(Math.max(Math.max(d[n][0], d[n][1]), d[n][2]));
		}
		br.close();
	}
}