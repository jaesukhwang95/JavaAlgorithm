package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b1406 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<String> before = new Stack<String>();
		Stack<String> after = new Stack<String>();
		for(int i=0; i<str.length(); i++)
		{
			before.push(String.valueOf(str.charAt(i)));
		}
		int n = Integer.parseInt(br.readLine());
		while(n-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("L"))
			{
				if(!before.isEmpty())
					after.push(before.pop());
			}
			else if(cmd.equals("D"))
			{
				if(!after.isEmpty())
					before.push(after.pop());
			}
			else if(cmd.equals("B"))
			{
				if(!before.isEmpty())
					before.pop();
			}
			else if(cmd.equals("P"))
			{
				before.push(st.nextToken());
			}
		}
		while (!before.empty()) {
            after.push(before.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!after.empty()) {
            sb.append(after.pop());
        }
		System.out.println(sb);
	}
}