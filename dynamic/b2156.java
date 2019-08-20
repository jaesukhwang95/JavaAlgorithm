package baekjoon.dynamic;
import java.io.*;

public class b2156 {
	
	public static int d[][];
	
	public static void go(int n, int[] arr)
	{
		d[n][0] = Math.max(Math.max(d[n-1][0], d[n-1][1]), d[n-1][2]);
		d[n][1] = Math.max(d[n-1][0]+arr[n-1], d[n-1][1]);
		d[n][2] = Math.max(d[n-1][1]+arr[n-1], d[n-1][2]);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n ; i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		d = new int[n+1][3];
		d[1][0] = 0;
		d[1][1] = arr[0];
		d[1][2] = 0;
		for(int i=2; i<n+1 ; i++)
		{
			go(i, arr);
		}
		System.out.println(Math.max(Math.max(d[n][0], d[n][1]), d[n][2]));
		br.close();
	}
}
