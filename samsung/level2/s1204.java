package baekjoon.samsung.level2;
import java.util.*;
import java.io.*;

public class s1204 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int num=0; num<n; num++)
		{
			br.readLine();
			int min = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] arr = new int [101];
			for(int i = 0; i<1000 ;i++)
			{
				arr[Integer.parseInt(st.nextToken())] += 1;
			}
			for(int i=0; i<100 ;i++)
			{
				if(arr[min] <= arr[i+1])
				{
					min = i+1;
				}
			}
			sb.append("#").append(num+1).append(" ").append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
