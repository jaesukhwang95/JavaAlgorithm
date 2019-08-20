package baekjoon.samsung;
import java.io.*;

public class s1946 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int j = 1;
		while(total-->0)
		{
			int cases = Integer.parseInt(br.readLine());
			bw.write("#"+String.valueOf(j)+"\n");
			while(cases-->0)
			{
				String[] str = br.readLine().split(" ");
				for(int i=0; i<Integer.parseInt(str[1]); i++)
				{
					sb.append(str[0]);
				}
			}
			int k = 0;
			while(k+10 <= sb.toString().length())
			{
				bw.write(sb.toString().substring(k, k+10)+"\n");
				k +=10;
			}
			bw.write(sb.toString().substring(k)+"\n");
			j++;
			sb.delete(0, sb.length());
		}
		br.close();
		bw.close();
	}
}
