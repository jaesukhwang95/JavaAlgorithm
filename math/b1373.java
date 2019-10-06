package baekjoon.math;
import java.util.*;
import java.io.*;

public class b1373 {
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.nextLine();
		int len = str.length();
		if(len%3 == 1)
			sb.append(str.charAt(0));
		else if(len%3 == 2)
			sb.append((str.charAt(0)-'0')*2+(str.charAt(1)-'0'));
		for(int i=len%3; i<len-2 ;i=i+3)
		{
			sb.append((str.charAt(i)-'0')*4+(str.charAt(i+1)-'0')*2+(str.charAt(i+2)-'0'));
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
