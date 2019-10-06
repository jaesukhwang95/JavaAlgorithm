package baekjoon.math;
import java.util.*;
import java.io.*;

public class b2745 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int a = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i=str.length()-1; i>=0 ;i--)
		{
			int num = Integer.valueOf(str.charAt(i));
			if(num >= 65)
			{
				num -= 55;
			}
			else
			{
				num -= 48;
			}
			ans = (int) (ans + num * Math.pow(a, str.length()-1-i));
		}
		System.out.println(ans);
	}
}
