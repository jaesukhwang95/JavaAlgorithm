package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b10866 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> d = new ArrayDeque<Integer>();
		while(n-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push_front"))
			{
				d.offerFirst(Integer.parseInt(st.nextToken()));
			}
			else if(cmd.equals("push_back"))
			{
				d.offerLast(Integer.parseInt(st.nextToken()));
			}
			else if(cmd.equals("pop_front"))
			{
				if(!d.isEmpty())
					sb.append(d.pollFirst()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			else if(cmd.equals("pop_back"))
			{
				if(!d.isEmpty())
					sb.append(d.pollLast()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			else if(cmd.equals("size"))
			{
				sb.append(d.size()).append("\n");
			}
			else if(cmd.equals("empty"))
			{
				if(!d.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
			}
			else if(cmd.equals("front"))
			{
				if(!d.isEmpty())
					sb.append(d.peekFirst()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			else if(cmd.equals("back"))
			{
				if(!d.isEmpty())
					sb.append(d.peekLast()).append("\n");
				else
					sb.append(-1).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
