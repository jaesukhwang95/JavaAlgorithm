package baekjoon.samsung.level3;
import java.io.*;
import java.util.*;

public class s1206 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for(int num=0; num<10 ;num++)
		{
			int sum = 0;
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int [n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=2; i<n-2 ;i++)
			{
				int min = Integer.MAX_VALUE;
				int [] dist = new int [4];
				dist[0] = arr[i] - arr[i-2];
				dist[1] = arr[i] - arr[i-1];
				dist[2] = arr[i] - arr[i+2];
				dist[3] = arr[i] - arr[i+1];
				for(int j=0; j<4 ;j++)
				{
					if(dist[j]<0)
					{
						min = 0;
						break;
					}
					else
						min = Math.min(min, dist[j]);
				}
				sum += min;
			}
			sb.append("#").append(num+1).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
