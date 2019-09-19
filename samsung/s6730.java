package baekjoon.samsung;
import java.io.*;
import java.util.*;

public class s6730 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int j = 1;
		while(t-->0)
		{
			int up = 0;
			int down = 0;
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] arr = new int[n];
			for(int i=0; i<n ;i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<n-1 ;i++)
			{
				if(arr[i]<arr[i+1])
				{
					up = Math.max(up, arr[i+1]-arr[i]);
				}
				else
				{
					down = Math.max(down, arr[i]-arr[i+1]);
				}
			}
			sb.append("#").append(j).append(" ").append(up).append(" ").append(down).append("\n");
			j++;
		}	
	bw.write(sb.toString());
	br.close();
	bw.close();
	}
}