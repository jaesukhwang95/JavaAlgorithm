package baekjoon.recursion;
import java.io.*;
import java.util.*;

// + : 1 , - : -1, 0 : 0
 
public class b1248 {
	
	public static char [][] s;
	public static int n;
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public static boolean check(int idx)
	{
		int sum = 0;
		boolean ans = true;
		for(int j=idx; j>=0 ;j--)
		{
			sum += arr.get(j);
			if(s[j][idx] == '+' && sum <= 0)
				return false;
			if(s[j][idx] == '-' && sum >= 0)
				return false;
			if(s[j][idx] == '0' && sum != 0)
				return false;
		}
		return ans;
	}
	
	public static void go(int idx)
	{
		if(idx == n)
		{
			for(int i=0; i<arr.size() ;i++)
			{
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			System.exit(0);
		}
		for(int i=-10; i<=10 ;i++)
		{
			arr.add(i);
			if(check(idx))
			{
				go(idx+1);
			}
			arr.remove(arr.size()-1);
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new char [n][n];
		String str = br.readLine();
		int k = 0;
		for(int i=0; i<n ;i++)
		{
			for(int j=i; j<n ;j++)
			{
				s[i][j] = str.charAt(k);
				k++;
			}
		}
		go(0);
	}
}
