package baekjoon.samsung;
import java.io.*;

public class s1215 {
	public static boolean palindrom(String str)
	{
		for(int i=0; i<str.length()/2+1 ; i++)
		{
			if(str.charAt(i) != str.charAt(str.length()-i-1))
				return false;
		}
		return true;
	}
	
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = 10;
		int l = 1;
		while(t-->0)
		{
			int ans = 0;
			int n = Integer.parseInt(br.readLine());
			char [][] arr = new char[9][9];
			for(int i=1; i<=8; i++)
			{
				String str = br.readLine();
				for(int j=1; j<=8; j++)
				{
					arr[i][j] = str.charAt(j-1);
				}
			}
			String str = "";
			for(int i=1; i<=8; i++)
			{
				for(int j=1; j<=9-n; j++)
				{
					for(int k=j; k<=j+n-1;k++)
						str += arr[i][k];
					if(palindrom(str))
						ans += 1;
					str = "";
				}
			}
			for(int i=1; i<=8; i++)
			{
				for(int j=1; j<=9-n; j++)
				{
					for(int k=j; k<=j+n-1;k++)
						str += arr[k][i];
					if(palindrom(str))
						ans += 1;
					str = "";
				}
			}
			sb.append("#").append(l).append(" ").append(ans).append("\n");
			l++;
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
