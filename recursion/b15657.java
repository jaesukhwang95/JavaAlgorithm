package baekjoon.recursion;
import java.util.*;
import java.io.*;

public class b15657 {
	
	public static int n,m;
	public static int [] arr;
	public static int [] num;
	public static StringBuilder ans = new StringBuilder();
	
	public static void go(int idx, int start)
	{
		if(idx == m)
		{
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<m; i++)
			{
				sb.append(arr[i]);
				if(i != m-1)
					sb.append(" ");
			}
			sb.append("\n");
			ans.append(sb.toString());
			return;
		}
		for(int i=start; i<=n ;i++)
		{
			arr[idx] = num[i-1];
			go(idx+1, i);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int [m];
		num = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n ;i++)
		{
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		go(0, 1);
		bw.write(ans.toString());
		bw.close();
		br.close();
	}
}
