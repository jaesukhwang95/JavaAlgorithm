package baekjoon.samsung.level3;
import java.util.*;
import java.io.*;

public class s7728 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String[] arr = new String[t];
		for(int i=0; i<t ;i++)
		{
			arr[i] = br.readLine();
		}
		for(int i=0; i<t ;i++)
		{
			String str = arr[i];
			HashSet<Character> 	charSet = new HashSet<Character>();
			for(int j=0; j<str.length(); j++)
			{
				charSet.add(str.charAt(j));
			}
			sb.append("#").append(i+1).append(" ").append(charSet.size()).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
