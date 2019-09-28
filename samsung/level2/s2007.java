package baekjoon.samsung.level2;
import java.io.*;

public class s2007 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int j = 0;
		while(t-->0)
		{
			String str = br.readLine();
			for(int i=1; i<11 ;i++)
			{
				if(str.substring(0, i).equals(str.substring(i, 2*i)))
				{
					j++;
					sb.append("#").append(j).append(" ").append(i).append("\n");
					break;
				}
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}