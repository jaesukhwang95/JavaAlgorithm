package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b11656 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String[] arr = new String[str.length()];
		for(int i=0; i<str.length() ;i++)
		{
			arr[i] = str.substring(i);
		}
		Arrays.sort(arr);
		for(int i=0; i<str.length() ;i++)
		{
			sb.append(arr[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
