package baekjoon.samsung;
import java.io.*;

public class s4406 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		int j = 1;
		StringBuilder ans = new StringBuilder();
		while(t-->0)
		{
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<str.length(); i++)
			{
				if(str.charAt(i) != 'a' &&  str.charAt(i) != 'e' &&
						str.charAt(i) != 'i' && str.charAt(i) != 'o' && str.charAt(i) != 'u')
				{
					sb.append(str.charAt(i));
				}
			}
			ans.append("#").append(j).append(" ").append(sb).append("\n");
			j++;
		}
		bw.write(ans.toString());
		bw.close();
		br.close();
	}
}
