package baekjoon.recursion;
import java.util.Arrays;
import java.util.Scanner;

public class b1759 {
	
	public static boolean check(String arr)
	{
		int len = arr.length();
		int ja=0;
		int mo=0;
		for(int i = 0; i<len ;i++)
		{
			if(arr.charAt(i) == 'a' || arr.charAt(i) == 'e' || arr.charAt(i) == 'i' || arr.charAt(i) == 'o' || arr.charAt(i) == 'u')
				mo++;
			else
				ja++;
		}
		return (mo>=1 && ja>=2);
	}

	public static void go( char arr[] ,String sol, int len, int idx )
	{
		if(sol.length() == len)
			if(check(sol))
			{
				System.out.printf("%s\n", sol);
				return;
			}
		if(idx >= arr.length)
		{
			return;
		}
		go(arr, sol+arr[idx], len, idx+1);
		go(arr, sol, len, idx+1);
	}
	
	public static void main(String args [])
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int all = sc.nextInt();
		String sol = "";
		char arr [] = new char [all];
		for(int i=0; i<all ;i++)
		{
			arr[i] = sc.next().charAt(0);
		}
		Arrays.sort(arr);
		go(arr,sol,num,0);
	}
}
