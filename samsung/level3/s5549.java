package baekjoon.samsung.level3;

import java.io.*;

public class s5549 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t ;i++)
		{
			String str = br.readLine();
			if((str.charAt(str.length()-1) - '0') % 2 == 0)
			{
				sb.append("#").append(i).append(" ").append("Even").append("\n");
			}
			else
			{
				sb.append("#").append(i).append(" ").append("Odd").append("\n");
			}	
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}


//5
//1
//10
//100
//1857871243687123868253872738711
//82518881239123819238912929292