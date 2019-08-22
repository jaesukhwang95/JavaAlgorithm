package baekjoon.samsung;
import java.io.*;
import java.util.*;

public class s3431 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int num = 1;
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			int input = Integer.parseInt(st.nextToken());
			if(input < min)
				sb.append("#").append(num).append(" ").append(min-input).append("\n");
			else if(min <= input && input <= max)
				sb.append("#").append(num).append(" ").append(0).append("\n");
			else
				sb.append("#").append(num).append(" ").append(-1).append("\n");
			num++;
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
