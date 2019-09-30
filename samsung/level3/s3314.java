package baekjoon.samsung.level3;
import java.io.*;
import java.util.*;

public class s3314 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j=0; j<5 ;j++)
			{
				int num = Integer.parseInt(st.nextToken());
				if(num<40)
					num = 40;
				sum += num;
			}
			
			sb.append("#").append(i+1).append(" ").append(sum/5).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
