package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b9019 {
	
	public static int D(int num)
	{
		int result = num * 2;
		if(result>9999)
		{
			result = result % 10000;
		}
		return result;
	}
	
	public static int S(int num)
	{
		int result = num - 1;
		if(result == -1)
		{
			result = 9999;
		}
		return result;
	}
	
	public static int L(int num)
	{
		int result = 0;
		int tmp = num / 1000;
		num -= tmp*1000;
		result += tmp;
		tmp = num / 100;
		result += tmp*1000;
		num -= tmp*100;
		tmp = num / 10;
		result += tmp*100;
		num -= tmp*10;
		result += num*10;
		return result;
	}
	
	public static int R(int num)
	{
		int result = 0;
		int tmp = num / 1000;
		num -= tmp*1000;
		result += tmp*100;
		tmp = num / 100;
		result += tmp*10;
		num -= tmp*100;
		tmp = num / 10;
		result += tmp;
		num -= tmp*10;
		result += num*1000;
		return result;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int idx=0; idx<t ;idx++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean [] visit = new boolean[10000];
			String [] str = new String[10000];
			Arrays.fill(str, "");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(a);
			visit[a] = true;
			while(!q.isEmpty() && !visit[b])
			{
				int c = q.poll();
				int d = D(c);
				if(!visit[d])
				{
					str[d] = str[c] + "D";
					visit[d] = true;
					q.offer(d);
				}
				int s = S(c);
				if(!visit[s])
				{
					str[s] = str[c] + "S";
					visit[s] = true;
					q.offer(s);
				}
				int l = L(c);
				if(!visit[l])
				{
					str[l] = str[c] + "L";
					visit[l] = true;
					q.offer(l);
				}
				int r = R(c);
				if(!visit[r])
				{
					str[r] = str[c] + "R";
					visit[r] = true;
					q.offer(r);
				}
			}
			sb.append(str[b]+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
