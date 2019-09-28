package baekjoon.samsung.level2;
import java.io.*;

public class s1926 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		String[] str = new String[1000];
		for(int i=0; i<num; i++)
		{
			int cnt = 0;
			str[i] = String.valueOf(i+1);
			for(int j=0; j<str[i].length() ;j++)
			{
				if((str[i].charAt(j)) == '3' || (str[i].charAt(j)) == '6' || (str[i].charAt(j)) == '9')
				{
					cnt++;
				}
			}
			if(cnt==0)
			{
			}
			else if(cnt==1)
			{
				str[i] = "-";
			}
			else if(cnt==2)
			{
				str[i] = "--";
			}
			else
			{
				str[i] = "---";
			}
			sb.append(str[i]).append(" ");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
