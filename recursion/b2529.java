package baekjoon.recursion;
import java.util.*;
import java.io.*;

public class b2529 {
	
	static boolean [] check;
    static int n;
	static char [] op;
	static ArrayList<String> ans = new ArrayList<String>();
	
	public static boolean checkOp(char op, char left, char right)
	{
		boolean ans = true;
		if(op == '<')
		{
			if(left>right)
			{
				return false;
			}
		}
		else
		{
			if(left<right)
			{
				return false;
			}
		}
		return ans;
	}
	
	public static void go(int idx, String str)
	{
		if(idx == n+1)
		{
			ans.add(str);
			return;
		}
		for(int i=0; i<10; i++)
		{
			if(!check[i])
			{
				if(idx==0 || checkOp(op[idx-1], str.charAt(str.length()-1), (char)(i+'0')))
				{
					check[i] = true;
					go(idx+1, str+Integer.toString(i));
					check[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		op = new char[n];
		check = new boolean [10];
		for(int i=0; i<n ;i++)
		{
			op[i] = (st.nextToken()).charAt(0);
		}
		go(0, "");
		Collections.sort(ans);
		System.out.println(ans.get(ans.size()-1));
		System.out.println(ans.get(0));
	}
}
