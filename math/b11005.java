package baekjoon.math;
import java.util.*;
import java.io.*;

public class b11005 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		while(a != a/b)
		{
			int num = (a%b);
			if(num>=10)
			{
				sb.insert(0, (char)(a%b + 55));
			}
			else
				sb.insert(0, num);
			a = a/b;
		}
		System.out.println(sb.toString());		
	}
}