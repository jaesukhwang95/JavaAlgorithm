package baekjoon.samsung;
import java.io.*;

public class s1986 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int j = 1;
		while(total-->0)
		{
			int sum = 1;
			int num = Integer.parseInt(br.readLine());
			for(int i=2; i<=num; i++)
			{
				if(i%2==0)
				{
					sum -= i;
				}
				else
				{
					sum += i;
				}
			}
			sb.append("#").append(j).append(" ").append(sum).append("\n");
			j++;
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
