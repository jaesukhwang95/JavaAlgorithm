package baekjoon.dataStructure;
import java.io.*;

public class b10809 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int[] arr = new int[26];
		for(int i=0; i<26; i++)
		{
			arr[i] = -1;
		}
		for(int i=0; i<str.length(); i++)
		{
			if(arr[str.charAt(i)-97] == -1)
				arr[str.charAt(i)-97] = i;
		}
		for(int i=0; i<26; i++)
		{
			sb.append(arr[i]).append(" ");
		}
		sb.append("\n");
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}