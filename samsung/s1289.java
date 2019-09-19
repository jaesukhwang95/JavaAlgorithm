package baekjoon.samsung;
import java.io.*;

public class s1289 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());		
		int num = 1;
		StringBuilder ans = new StringBuilder();
		while(t-->0)
		{
			int cnt = 0;
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<str.length(); i++)
				sb.append("0");
			String origin = sb.toString();
			int index = 0;
			while(!str.equals(origin))
			{
				 for(int j=index; j<str.length() ;j++)
				 {
					 if(str.charAt(j) != origin.charAt(j))
					 {
						 cnt++;
						 origin = origin.substring(0, j);
						 StringBuilder add = new StringBuilder();
						 for(int k=j; k<str.length() ;k++)
						 {
							 add.append(str.charAt(j));
						 }
						 origin = origin + add.toString();
						 index = j;
						 break;
					 }
				 }
			}
			ans.append("#").append(num).append(" ").append(cnt).append("\n");
			num++;
		}
		bw.write(ans.toString());
		bw.close();
		br.close();
	}
}
