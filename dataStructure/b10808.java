package baekjoon.dataStructure;
import java.io.*;

public class b10808 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int [] arr = new int[26];
		String str = br.readLine();
		for(int i=0; i<str.length(); i++)
		{
			arr[str.charAt(i)-97] += 1;
		}
		for(int i=0; i<26 ;i++)
		{
			sb.append(arr[i]).append(" ");
		}
		sb.append("\n");
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}