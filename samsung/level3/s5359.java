package baekjoon.samsung.level3;

import java.io.*;

public class s5359 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=t ;i++)
		{
			char [][] arr = new char[5][15];
			int len = Integer.MIN_VALUE;
			for(int j=0; j<5; j++)
			{
				String str = br.readLine();
				for(int k=0; k<str.length(); k++)
				{
					arr[j][k] = str.charAt(k);
				}
				len = Math.max(len, str.length());
			}
			sb.append("#").append(i).append(" ");
			for(int j=0; j<len ;j++)
			{
				for(int k=0; k<5 ;k++)
				{
					if(Integer.valueOf(arr[k][j]) != 0)
					sb.append(arr[k][j]);
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
