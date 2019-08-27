package baekjoon.dataStructure;
import java.io.*;

public class b9012 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(n-->0)
		{
			cnt = 0;
			String str = br.readLine();
			Loop:for(int i=0; i<str.length() ; i++)
			{
				if(str.charAt(i)=='(')
				{
					cnt++;
				}
				else if(str.charAt(i)==')')
				{
					cnt--;
				}
				if(cnt<0)
				{
					break Loop;
				}
			}
			if(cnt!=0)
			{
				sb.append("NO").append("\n");
			}
			else
			{
				sb.append("YES").append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}