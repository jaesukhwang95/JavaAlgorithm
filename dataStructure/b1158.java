package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b1158 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=n ;i++)
		{
			q.offer(i);
		}
		sb.append("<");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m-1; j++)
			{
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}
}