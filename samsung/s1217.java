package baekjoon.samsung;
import java.io.*;
import java.util.*;

public class s1217 {
	
	public static int pow(int a, int b)
	{
		if(b==0)
			return 1;
		else
			return a * pow(a, b-1);
			
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = 10;
		int j = 1;
		while(t-->0)
		{
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append("#").append(j).append(" ").append(pow(a,b)).append("\n");
			j++;
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}