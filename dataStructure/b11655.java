package baekjoon.dataStructure;
import java.io.*;

public class b11655 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		for(int i=0; i<str.length(); i++)
		{
			char alphabet = (str.charAt(i));
			if('a'<=alphabet && alphabet<='m')
			{
				alphabet += 13;
			}
			else if('n'<=alphabet && alphabet<='z')
			{
				alphabet -= 13;
			}
			else if('A'<=alphabet && alphabet<='M')
			{
				alphabet += 13;
			}
			else if('N'<=alphabet && alphabet<='Z')
			{
				alphabet -= 13;
			}
			sb.append(alphabet);
		}
		sb.append("\n");
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
