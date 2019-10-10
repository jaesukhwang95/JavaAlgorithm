package baekjoon.samsung.level3;

import java.io.*;

public class s1213 {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int num=1; num<=10 ;num++)
		{
			br.readLine();
			String find = br.readLine();
			String str = br.readLine();
			int findLen = find.length();
			int strLen = str.length();
			int cnt = 0;
			for(int j=0; j<strLen-findLen+1 ;j++)
			{
				String subStr = str.substring(j, j+findLen);
				if(subStr.equals(find))
					cnt++;
			}
			sb.append("#").append(num).append(" ").append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
