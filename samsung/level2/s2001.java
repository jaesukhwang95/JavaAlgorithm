package baekjoon.samsung.level2;
import java.io.*;
import java.util.*;

public class s2001 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int n = 0;
		int m = 0;
		int cnt = 1;
		while(total-->0)
		{
			int max = Integer.MIN_VALUE;
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int [][] a = new int [n][n];
			for(int i=0; i<n ; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n ;j++)
						a[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int k=0; k<n-m+1 ;k++)
				for(int l=0; l<n-m+1; l++)
				{
					for(int o=k; o<k+m ;o++)
						for(int p=l; p<l+m ;p++)
							sum += a[o][p];
					max = Math.max(max, sum);
					sum = 0;
				}
			sb.append("#").append(cnt).append(" ").append(max).append("\n");
			cnt++;
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
