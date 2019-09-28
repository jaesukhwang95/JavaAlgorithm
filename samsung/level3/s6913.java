package baekjoon.samsung.level3;
import java.util.*;
import java.io.*;

public class s6913 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int [][] arr = new int[n][m];
			for(int k=0; k<n ;k++)
			{
				st = new StringTokenizer(br.readLine());
				for(int l=0; l<m ;l++)
				{
					arr[k][l] = Integer.parseInt(st.nextToken());
				}
			}
			int [] s = new int [n];
			for(int k=0; k<n ;k++)
			{
				int sum = 0;
				for(int l=0; l<m ;l++)
				{
					sum += arr[k][l];
				}
				s[k] = sum;
			}
			Arrays.sort(s);
			int cnt = 0;
			int idx = n-1;
			while(idx>=0 && s[idx] == s[n-1])
			{
				idx--;
				cnt++;
			}
			sb.append("#").append(i+1).append(" ").append(cnt).append(" ").append(s[n-1]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
