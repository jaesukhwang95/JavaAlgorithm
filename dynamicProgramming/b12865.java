package baekjoon.dynamicProgramming;
import java.util.*;
import java.io.*;

public class b12865 {
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [][] d = new int [n+1][k+1];
		int [] w = new int [n+1];
		int [] v = new int [n+1];
		for(int i=1; i<=n; i++)
		{
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int j=1; j<=k; j++)
		{
			for(int i=1; i<=n ;i++)
			{
				if(j>=w[i])
				{
					d[i][j] = Math.max(d[i-1][j], d[i-1][j-w[i]]+v[i]);
				}
				else
					d[i][j] = d[i-1][j];
			}
		}
		System.out.println(d[n][k]);
	}	
}