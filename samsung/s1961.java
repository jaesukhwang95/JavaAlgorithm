package baekjoon.samsung;
import java.io.*;
import java.util.*;

public class s1961 {
	public static int[][] rotate(int[][] arr, int n)
	{
		int[][] res = new int[n][n];
		for(int i=0; i<n ; i++)
			for(int j=0; j<n ; j++)
				res[j][n-i-1] = arr[i][j];
		return res;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		int total = Integer.parseInt(br.readLine());
		while(total-->0)
		{
			int n = Integer.parseInt(br.readLine());
			int [][] arr = new int[n][n];
			String [][] res = new String[n][n];
			for(int j=0; j<n ;j++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i=0; i<n ; i++)
				{
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}	
			for(int k=0; k<3 ; k++)
			{
				arr = rotate(arr, n);
				for(int i=0; i<n; i++)
				{
					res[i][k] = "";
					for(int j=0; j<n; j++)
					{
						res[i][k] += String.valueOf(arr[i][j]);
					}
				}
			}
			sb.append("#").append(cnt).append("\n");
			for(int i=0; i<n ; i++)
			{
				for(int j=0; j<3 ; j++)
					sb.append(res[i][j]).append(" ");
				sb.append("\n");
			}
			cnt++;
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
