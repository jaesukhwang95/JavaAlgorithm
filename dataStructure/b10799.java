package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b10799 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Integer> s = new Stack<Integer>();
		int ans = 0;
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i) == '(')
			{
				s.push(i);
			}
			else
			{
				if(s.peek()+1 == i)
				{
					s.pop();
					ans += s.size();
				}
				else
				{
					ans += 1;
					s.pop();
				}
			}
		}
		System.out.println(ans);
	}
}
