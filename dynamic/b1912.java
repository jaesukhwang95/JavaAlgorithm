package baekjoon.dynamic;
import java.io.*;
import java.util.*;

public class b1912 {
	
	public static int[] d;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n+1];
		d = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		d[1] = arr[1];
		for(int i=2; i<=n; i++)
		{
			d[i] = Math.max(d[i-1]+arr[i], arr[i]);
		}
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++)
		{
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}
}
