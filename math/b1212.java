package baekjoon.math;
import java.util.*;

public class b1212 {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		String [] conv = {"000","001","010","011","100","101","110","111"};
		
		int first = str.charAt(0) - '0';
		if(first == 0)
		{
			sb.append("0");
		}
		else if(first == 1)
		{
			sb.append("1");
		}
		else if(first == 2)
		{
			sb.append("10");
		}
		else if(first == 3)
		{
			sb.append("11");
		}
		else
		{
			sb.append(conv[first]);
		}
		
		for(int i=1; i<str.length() ;i++)
		{
			int digit = str.charAt(i) - '0';
			sb.append(conv[digit]);
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
