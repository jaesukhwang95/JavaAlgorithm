package baekjoon.samsung.level2;
import java.util.*;
import java.io.*;

public class s1859 {
	
	public static void main(String[] args) throws IOException
	{
		 System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 StringBuilder sb = new StringBuilder();

		 int t = Integer.parseInt(br.readLine());
		 for(int num=0; num<t; num++)
		 {
			 int n = Integer.parseInt(br.readLine());
			 int [] arr = new int [n];
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 for(int i=0; i<n ;i++)
			 {
				 arr[i] = Integer.parseInt(st.nextToken());
			 }
			 int max = arr[n-1];
			 long sum = 0;
			 for(int i=n-2; i>=0; i--)
			 {
				 if(arr[i] >= max)
					 max = arr[i];
				 else
					 sum += max - arr[i];
			 }
			 if(sum<0)
				 sb.append("#").append(num+1).append(" ").append(0).append("\n");
			 else
				 sb.append("#").append(num+1).append(" ").append(sum).append("\n");
		 }
		 bw.write(sb.toString());
		 bw.close();
		 br.close();
	}
}