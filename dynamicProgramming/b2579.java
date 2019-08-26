package baekjoon.dynamicProgramming;
import java.io.*;

public class b2579 {
	
	public static int[][] d;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		d = new int[n+1][3];
		for(int i=1; i<=n; i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		d[1][1] = arr[1];
		d[2][1] = arr[2];
		d[2][2] = arr[1]+arr[2];
		for(int i=3; i<=n; i++)
		{
			d[i][1] = Math.max(d[i-2][1], d[i-2][2])+arr[i];
			d[i][2] = d[i-1][1]+arr[i];
		}
		int max = Integer.MIN_VALUE;
		for(int j=1; j<=2 ;j++)
			max = Math.max(max, d[n][j]);
		System.out.println(max);
	}
}