package baekjoon.recursion;
import java.util.*;
import java.io.*;

public class b15654 {
	
	public static int n,m;
	public static int [] arr;
	public static boolean [] visit;
	public static int [] num;
	public static StringBuilder ans = new StringBuilder();
	
	public static void go(int idx)
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
		for(int i=1; i<=n ;i++)
		{
			if(!visit[i])
			{
				visit[i] = true;
				arr[idx] = num[i-1];
				go(idx+1);
				visit[i] = false;
			}
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
		visit = new boolean [n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n ;i++)
		{
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		go(0);
		bw.write(ans.toString());
		bw.close();
		br.close();
	}
}
