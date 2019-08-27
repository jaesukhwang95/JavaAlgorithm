package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b10828 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<Integer>();
		while(n-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push"))
			{
				int num = Integer.parseInt(st.nextToken());
				s.push(num);
			}
			else if(cmd.equals("pop"))
			{
				if(!s.isEmpty())
				{
					sb.append(s.pop()).append("\n");
				}
				else
				{
					sb.append(-1).append("\n");
				}
			}
			else if(cmd.equals("size"))
			{
				sb.append(s.size()).append("\n");
			}
			else if(cmd.equals("empty"))
			{
				if(!s.isEmpty())
				{
					sb.append(0).append("\n");
				}
				else
				{
					sb.append(1).append("\n");
				}
			}
			else if(cmd.equals("top"))
			{
				if(!s.isEmpty())
				{
					sb.append(s.peek()).append("\n");
				}
				else
				{
					sb.append(-1).append("\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
