package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b10845 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		int back = 0;
		int n = Integer.parseInt(br.readLine());
		while(n-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push"))
			{
				back = Integer.parseInt(st.nextToken());
				q.offer(back);
			}
			else if(cmd.equals("pop"))
			{
				if(!q.isEmpty())
					sb.append(q.poll()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			else if(cmd.equals("size"))
			{
				sb.append(q.size()).append("\n");
			}
			else if(cmd.equals("empty"))
			{
				if(!q.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
			}
			else if(cmd.equals("front"))
			{
				if(!q.isEmpty())
					sb.append(q.peek()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			else if(cmd.equals("back"))
			{
				if(!q.isEmpty())
					sb.append(back).append("\n");
				else
					sb.append(-1).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
