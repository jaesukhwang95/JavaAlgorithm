package baekjoon.bruteForce;
import java.io.*;

public class b1748 {
	public static int digit(int num)
	{
		int len = 0;
		while(num != 0)
		{
			num = num / 10;
			len++;
		}
		return len;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i=1; i<=n ;i++)
		{
			ans += digit(i);
		}
		System.out.println(ans);	
	}
}