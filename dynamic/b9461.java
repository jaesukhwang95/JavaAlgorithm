package baekjoon.dynamic;
import java.io.*;

public class b9461 {
	
	public static long[] d;
 	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			d = new long[n+4];
			d[1] = 1;
			d[2] = 1;
			d[3] = 1;
			for(int i=4; i<=n ;i++)
			{
				d[i] = d[i-2] + d[i-3];
			}
			sb.append(d[n]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
