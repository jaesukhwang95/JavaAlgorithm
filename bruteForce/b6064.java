package baekjoon.bruteForce;
import java.io.*;
import java.util.*;

public class b6064 {
	
	public static int lcm(int a, int b) {
		 int A = a;
		 int B = b;
		 int temp;
		 while(b!=0)
		 {
			 temp = a;
			 a = b;
			 b = temp%b;
		 }
		 return A * B / a;
    }
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				boolean signal = false;
				if(y==n)	
				{
					y = 0;
				}
				for(int i = x; i <= lcm(m,n) ;i = i+m)
				{
					if(i%n == y)
					{
						
						sb.append(i).append("\n");
						signal = true;
						break;
					}
				}
				if(!signal)
				{
					sb.append(-1).append("\n");
				}
		}
		bw.write(sb.toString());
		bw.close();
	}
}
